package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.RefreshToken;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken();
    void validateRefreshToken(String token);
    void deleteRefreshToken(String token);
}
