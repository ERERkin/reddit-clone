package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.api.AuthenticationResponse;
import kg.erkin.springbackend.model.dto.api.LoginRequest;
import kg.erkin.springbackend.model.dto.api.RefreshTokenRequest;
import kg.erkin.springbackend.model.dto.api.RegisterRequest;
import kg.erkin.springbackend.model.dto.UserDto;

public interface AuthService {
    void signup(RegisterRequest registerRequest);
    UserDto getCurrentUser();
    void verifyAccount(String token);
    AuthenticationResponse login(LoginRequest loginRequest);
    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    boolean isLoggedIn();
}
