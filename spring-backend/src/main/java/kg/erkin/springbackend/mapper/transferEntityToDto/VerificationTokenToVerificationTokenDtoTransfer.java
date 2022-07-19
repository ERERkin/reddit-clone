package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter
public class VerificationTokenToVerificationTokenDtoTransfer extends AbstractTransferEntityToDto<VerificationToken, VerificationTokenDto> {
    @Autowired
    private UserToUserDtoTransfer userToUserDtoTransfer;

    @Override
    public VerificationTokenDto transferToDto(VerificationToken entity) {
        return entity == null ? null : VerificationTokenDto.builder()
                .id(entity.getId())
                .token(entity.getToken())
                .expiryDate(entity.getExpiryDate())
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
