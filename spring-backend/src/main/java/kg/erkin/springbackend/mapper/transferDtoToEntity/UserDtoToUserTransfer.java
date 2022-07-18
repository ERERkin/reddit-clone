package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserTransfer extends AbstractTransferDtoToEntity<User, UserDto> {
    @Override
    public User transferToEntity(UserDto dto) {
        return dto == null ? null : User.builder()
                .userId(dto.getUserId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .created(dto.getCreated())
                .enabled(dto.isEnabled())
                .build();
    }
}
