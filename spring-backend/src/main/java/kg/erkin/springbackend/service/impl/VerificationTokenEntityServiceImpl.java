package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.VerificationToken;
import kg.erkin.springbackend.repostitory.VerificationTokenRepository;
import kg.erkin.springbackend.service.VerificationTokenEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenEntityServiceImpl extends AbstractEntityService<VerificationToken, VerificationTokenRepository>
        implements VerificationTokenEntityService {
    public VerificationTokenEntityServiceImpl(VerificationTokenRepository repository) {
        super(repository);
    }

    @Override
    public VerificationToken findByToken(String token) {
        return repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid Token"));
    }
}
