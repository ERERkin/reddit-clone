package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter
public class VerificationTokenDtoToVerificationTokenTransfer extends AbstractTransferDtoToEntity<VerificationToken, VerificationTokenDto> {
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;

    @Override
    public VerificationToken transferToEntity(VerificationTokenDto dto) {
        return dto == null ? null : VerificationToken.builder()
                .id(dto.getId())
                .token(dto.getToken())
                .expiryDate(dto.getExpiryDate())
                .user(userDtoToUserTransfer.transferToEntity(dto.getUser()))
                .build();
    }
}
