package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.UserToUserDtoTransfer;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.service.UserEntityService;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractService<UserEntityService, User, UserDto,
        UserToUserDtoTransfer, UserDtoToUserTransfer>
        implements UserService {

    public UserServiceImpl(UserEntityService entityService, UserToUserDtoTransfer transferToDto, UserDtoToUserTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getByUsername(String username) {
        User user = entityService.getByUsername(username);
        return transferEntityToDto.transferToDto(user);
    }
}
