package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.AuthenticationResponse;
import kg.erkin.springbackend.model.dto.LoginRequest;
import kg.erkin.springbackend.model.dto.RefreshTokenRequest;
import kg.erkin.springbackend.model.dto.RegisterRequest;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.VerificationToken;

public interface AuthService {
    void signup(RegisterRequest registerRequest);
    User getCurrentUser();
    void verifyAccount(String token);
    AuthenticationResponse login(LoginRequest loginRequest);
    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    boolean isLoggedIn();
}
