package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.UserToUserDtoTransfer;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.UserRepository;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.base.AbstractService;
import kg.erkin.springbackend.service.base.BaseService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto, UserRepository,
        UserToUserDtoTransfer, UserDtoToUserTransfer>
        implements UserService {
    public UserServiceImpl(UserRepository repository, UserToUserDtoTransfer transferEntityToDto, UserDtoToUserTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findByUsername(String username) {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + username));
        return transferEntityToDto.transferToDto(user);
    }
}
