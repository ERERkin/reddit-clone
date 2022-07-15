package kg.erkin.springbackend.mapper.TransferEntityToDto;

import kg.erkin.springbackend.mapper.TransferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoTransfer extends AbstractTransferEntityToDto<User, UserDto> {
    @Override
    public UserDto transferToDto(User entity) {
        return entity == null ? null : UserDto.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .created(entity.getCreated())
                .enabled(entity.isEnabled())
                .build();
    }
}
