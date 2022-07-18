package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import org.springframework.stereotype.Component;

@Component
public class VerificationTokenToVerificationTokenDtoTransfer extends AbstractTransferEntityToDto<VerificationToken, VerificationTokenDto> {
    @Override
    public VerificationTokenDto transferToDto(VerificationToken entity) {
        return VerificationTokenDto.builder()
                .id(entity.getId())
                .build();
    }
}
