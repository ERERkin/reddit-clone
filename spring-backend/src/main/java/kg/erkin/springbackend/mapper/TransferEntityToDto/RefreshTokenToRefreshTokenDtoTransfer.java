package kg.erkin.springbackend.mapper.TransferEntityToDto;

import kg.erkin.springbackend.mapper.TransferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.RefreshTokenDto;
import kg.erkin.springbackend.model.entity.RefreshToken;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenToRefreshTokenDtoTransfer extends AbstractTransferEntityToDto<RefreshToken, RefreshTokenDto> {
    @Override
    public RefreshTokenDto transferToDto(RefreshToken entity) {
        return null;
    }
}
