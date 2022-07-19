package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Setter
public class CommentToCommentDtoTransfer extends AbstractTransferEntityToDto<Comment, CommentDto> {
    private final PostToPostDtoTransfer postToPostDtoTransfer;
    private final UserToUserDtoTransfer userToUserDtoTransfer;

    public CommentToCommentDtoTransfer(@Lazy PostToPostDtoTransfer postToPostDtoTransfer,@Lazy UserToUserDtoTransfer userToUserDtoTransfer) {
        this.postToPostDtoTransfer = postToPostDtoTransfer;
        this.userToUserDtoTransfer = userToUserDtoTransfer;
    }

    @Override
    public CommentDto transferToDto(Comment entity) {
        return entity == null ? null : CommentDto.builder()
                .id(entity.getId())
                .text(entity.getText())
                .createdDate(entity.getCreatedDate())
                .post(postToPostDtoTransfer.transferToDto(entity.getPost()))
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
