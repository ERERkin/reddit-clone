package kg.erkin.springbackend.mapper.TransferDtoToEntity;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import org.springframework.stereotype.Component;

@Component
public class VerificationTokenDtoToVerificationTokenTransfer extends AbstractTransferDtoToEntity<VerificationToken, VerificationTokenDto> {
    @Override
    public VerificationToken transferToEntity(VerificationTokenDto dto) {
        return null;
    }
}
