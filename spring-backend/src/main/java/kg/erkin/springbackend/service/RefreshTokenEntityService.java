package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.service.base.BaseEntityService;

public interface RefreshTokenEntityService extends BaseEntityService<RefreshToken> {
    void validateRefreshToken(String token);
    void deleteRefreshToken(String token);
}
