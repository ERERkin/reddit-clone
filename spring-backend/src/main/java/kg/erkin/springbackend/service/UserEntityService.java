package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.service.base.BaseEntityService;

public interface UserEntityService extends BaseEntityService<User> {
    User getByUsername(String username);
}
