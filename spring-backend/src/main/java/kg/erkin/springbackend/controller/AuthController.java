package kg.erkin.springbackend.controller;

import kg.erkin.springbackend.model.dto.api.AuthenticationResponse;
import kg.erkin.springbackend.model.dto.api.LoginRequest;
import kg.erkin.springbackend.model.dto.api.RefreshTokenRequest;
import kg.erkin.springbackend.model.dto.api.RegisterRequest;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.RefreshTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<?> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/refresh/token")
    public ResponseEntity<?> refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }
}
