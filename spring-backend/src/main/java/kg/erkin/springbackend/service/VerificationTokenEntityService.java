package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.VerificationTokenDto;
import kg.erkin.springbackend.model.entity.VerificationToken;
import kg.erkin.springbackend.service.base.BaseEntityService;

public interface VerificationTokenEntityService extends BaseEntityService<VerificationToken> {
    VerificationToken findByToken(String token);
}
