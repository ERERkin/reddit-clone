package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.UserRepository;
import kg.erkin.springbackend.service.UserEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl extends AbstractEntityService<User, UserRepository>
        implements UserEntityService {
    public UserEntityServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + username));
    }
}
