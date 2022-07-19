package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenToRefreshTokenDtoTransfer extends AbstractTransferEntityToDto<RefreshToken, RefreshTokenDto> {
    @Override
    public RefreshTokenDto transferToDto(RefreshToken entity) {
        return entity == null ? null : RefreshTokenDto.builder()
                .id(entity.getId())
                .token(entity.getToken())
                .createdDate(entity.getCreatedDate())
                .build();
    }
}
