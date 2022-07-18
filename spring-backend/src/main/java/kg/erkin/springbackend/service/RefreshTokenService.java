package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.service.base.BaseService;

public interface RefreshTokenService extends BaseService<RefreshTokenDto> {
    RefreshTokenDto generateRefreshToken();

    void validateRefreshToken(String token);
    void deleteRefreshToken(String token);
}
