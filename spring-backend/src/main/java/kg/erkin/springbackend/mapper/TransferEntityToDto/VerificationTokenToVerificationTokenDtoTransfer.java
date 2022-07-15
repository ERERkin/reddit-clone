package kg.erkin.springbackend.mapper.TransferEntityToDto;

import kg.erkin.springbackend.mapper.TransferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import org.springframework.stereotype.Component;

@Component
public class VerificationTokenToVerificationTokenDtoTransfer extends AbstractTransferEntityToDto<VerificationToken, VerificationTokenDto> {
    @Override
    public VerificationTokenDto transferToDto(VerificationToken entity) {
        return null;
    }
}
