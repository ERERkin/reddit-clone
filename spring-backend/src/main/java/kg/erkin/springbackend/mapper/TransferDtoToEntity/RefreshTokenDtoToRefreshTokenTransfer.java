package kg.erkin.springbackend.mapper.TransferDtoToEntity;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenDtoToRefreshTokenTransfer extends AbstractTransferDtoToEntity<RefreshToken, RefreshTokenDto> {
    @Override
    public RefreshToken transferToEntity(RefreshTokenDto dto) {
        return RefreshToken.builder()
                .build();
    }
}
