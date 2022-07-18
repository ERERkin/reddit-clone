package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.repostitory.RefreshTokenRepository;
import kg.erkin.springbackend.service.RefreshTokenEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenEntityServiceImpl extends AbstractEntityService<RefreshToken, RefreshTokenRepository>
        implements RefreshTokenEntityService {
    public RefreshTokenEntityServiceImpl(RefreshTokenRepository repository) {
        super(repository);
    }

    @Override
    public void validateRefreshToken(String token) {
        repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid refresh Token"));
    }

    @Override
    public void deleteRefreshToken(String token) {
        repository.deleteByToken(token);
    }
}
