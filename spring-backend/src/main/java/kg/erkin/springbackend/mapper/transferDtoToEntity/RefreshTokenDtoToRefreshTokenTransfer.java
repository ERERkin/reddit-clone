package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenDtoToRefreshTokenTransfer extends AbstractTransferDtoToEntity<RefreshToken, RefreshTokenDto> {
    @Override
    public RefreshToken transferToEntity(RefreshTokenDto dto) {
        return dto == null ? null : RefreshToken.builder()
                .id(dto.getId())
                .token(dto.getToken())
                .createdDate(dto.getCreatedDate())
                .build();
    }
}
