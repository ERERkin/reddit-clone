package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.RefreshTokenDtoToRefreshTokenTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.RefreshTokenToRefreshTokenDtoTransfer;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.repostitory.RefreshTokenRepository;
import kg.erkin.springbackend.service.RefreshTokenEntityService;
import kg.erkin.springbackend.service.RefreshTokenService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl extends AbstractService<RefreshTokenEntityService, RefreshToken, RefreshTokenDto,
        RefreshTokenToRefreshTokenDtoTransfer, RefreshTokenDtoToRefreshTokenTransfer>
        implements RefreshTokenService {
    public RefreshTokenServiceImpl(RefreshTokenEntityService entityService, RefreshTokenToRefreshTokenDtoTransfer transferToDto, RefreshTokenDtoToRefreshTokenTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
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
        entityService.validateRefreshToken(token);
    }

    @Override
    public void deleteRefreshToken(String token) {
        entityService.deleteRefreshToken(token);
    }
}
