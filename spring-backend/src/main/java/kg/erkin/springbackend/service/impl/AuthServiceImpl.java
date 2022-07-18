package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.dto.api.AuthenticationResponse;
import kg.erkin.springbackend.model.dto.api.LoginRequest;
import kg.erkin.springbackend.model.dto.api.RefreshTokenRequest;
import kg.erkin.springbackend.model.dto.api.RegisterRequest;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.security.JwtProvider;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.RefreshTokenService;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.VerificationTokenService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final VerificationTokenService verificationTokenService;
    //    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    public AuthServiceImpl(UserService userService,
                           VerificationTokenService verificationTokenService,
                           AuthenticationConfiguration authenticationConfiguration,
                           JwtProvider jwtProvider,
                           RefreshTokenService refreshTokenService) throws Exception {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userService = userService;
        this.verificationTokenService = verificationTokenService;
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
        this.jwtProvider = jwtProvider;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public void signup(RegisterRequest registerRequest) {
        UserDto user = new UserDto();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        System.out.println(registerRequest.getPassword());
        System.out.println(user.getPassword());

        user = userService.save(user);

        String token = generateVerificationToken(user);

        System.out.println("Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token);
    }

    private String generateVerificationToken(UserDto user) {
        String token = UUID.randomUUID().toString();
        VerificationTokenDto verificationToken = new VerificationTokenDto();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenService.save(verificationToken);
        return token;
    }

    @Override
    public UserDto getCurrentUser() {
        Jwt principal = (Jwt) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userService.getByUsername(principal.getSubject());
    }

    @Override
    public void verifyAccount(String token) {
        VerificationTokenDto verificationToken = verificationTokenService.findByToken(token);
        fetchUserAndEnable(verificationToken);
    }

    private void fetchUserAndEnable(VerificationTokenDto verificationToken) {
        String username = verificationToken.getUser().getUsername();
        UserDto user = userService.getByUsername(username);
        user.setEnabled(true);
        userService.save(user);
    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .build();
    }

    @Override
    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
