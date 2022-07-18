package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.VerificationTokenDtoToVerificationTokenTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.VerificationTokenToVerificationTokenDtoTransfer;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import kg.erkin.springbackend.service.VerificationTokenEntityService;
import kg.erkin.springbackend.service.VerificationTokenService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenServiceImpl extends AbstractService<VerificationTokenEntityService, VerificationToken, VerificationTokenDto,
        VerificationTokenToVerificationTokenDtoTransfer, VerificationTokenDtoToVerificationTokenTransfer>
        implements VerificationTokenService {

    public VerificationTokenServiceImpl(VerificationTokenEntityService entityService, VerificationTokenToVerificationTokenDtoTransfer transferToDto, VerificationTokenDtoToVerificationTokenTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
    }

    @Override
    public VerificationTokenDto findByToken(String token) {
        VerificationToken verificationToken = entityService.findByToken(token);
        return transferEntityToDto.transferToDto(verificationToken);
    }
}
