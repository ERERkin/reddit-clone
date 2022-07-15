package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.service.base.BaseService;

public interface VerificationTokenService extends BaseService<VerificationTokenDto> {
    VerificationTokenDto findByToken(String token);
}
