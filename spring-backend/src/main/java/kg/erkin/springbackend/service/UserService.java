package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.service.base.BaseService;

public interface UserService extends BaseService<UserDto> {
    UserDto findByUsername(String username);
}
