package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.VerificationTokenDtoToVerificationTokenTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.VerificationTokenToVerificationTokenDtoTransfer;
import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import kg.erkin.springbackend.repostitory.VerificationTokenRepository;
import kg.erkin.springbackend.service.VerificationTokenService;
import kg.erkin.springbackend.service.base.AbstractService;
import kg.erkin.springbackend.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenServiceImpl extends AbstractService<VerificationToken, VerificationTokenDto, VerificationTokenRepository,
        VerificationTokenToVerificationTokenDtoTransfer, VerificationTokenDtoToVerificationTokenTransfer>
        implements VerificationTokenService {
    public VerificationTokenServiceImpl(VerificationTokenRepository repository, VerificationTokenToVerificationTokenDtoTransfer transferEntityToDto, VerificationTokenDtoToVerificationTokenTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Override
    public VerificationTokenDto findByToken(String token) {
        VerificationToken verificationToken = repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid Token"));
        return transferEntityToDto.transferToDto(verificationToken);
    }
}
