package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.RefreshTokenDtoToRefreshTokenTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.RefreshTokenToRefreshTokenDtoTransfer;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.repostitory.RefreshTokenRepository;
import kg.erkin.springbackend.service.RefreshTokenService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl extends AbstractService<RefreshToken, RefreshTokenDto, RefreshTokenRepository,
        RefreshTokenToRefreshTokenDtoTransfer, RefreshTokenDtoToRefreshTokenTransfer>
        implements RefreshTokenService {
    public RefreshTokenServiceImpl(RefreshTokenRepository repository, RefreshTokenToRefreshTokenDtoTransfer transferEntityToDto, RefreshTokenDtoToRefreshTokenTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Override
    public RefreshTokenDto generateRefreshToken() {
        RefreshTokenDto refreshToken = new RefreshTokenDto();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return save(refreshToken);
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
