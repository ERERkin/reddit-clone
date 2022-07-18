package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class CommentToCommentDtoTransfer extends AbstractTransferEntityToDto<Comment, CommentDto> {
    private PostToPostDtoTransfer postToPostDtoTransfer;
    private UserToUserDtoTransfer userToUserDtoTransfer;

    @Override
    public CommentDto transferToDto(Comment entity) {
        return CommentDto.builder()
                .id(entity.getId())
                .text(entity.getText())
                .createdDate(entity.getCreatedDate())
                .post(postToPostDtoTransfer.transferToDto(entity.getPost()))
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
