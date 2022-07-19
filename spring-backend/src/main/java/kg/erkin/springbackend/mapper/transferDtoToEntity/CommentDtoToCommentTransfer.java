package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToCommentTransfer extends AbstractTransferDtoToEntity<Comment, CommentDto> {
    private final PostDtoToPostTransfer postDtoToPostTransfer;
    private final UserDtoToUserTransfer userDtoToUserTransfer;

    public CommentDtoToCommentTransfer(@Lazy PostDtoToPostTransfer postDtoToPostTransfer,@Lazy UserDtoToUserTransfer userDtoToUserTransfer) {
        this.postDtoToPostTransfer = postDtoToPostTransfer;
        this.userDtoToUserTransfer = userDtoToUserTransfer;
    }

    @Override
    public Comment transferToEntity(CommentDto dto) {
        return Comment.builder()
                .id(dto.getId())
                .text(dto.getText())
                .createdDate(dto.getCreatedDate())
                .post(postDtoToPostTransfer.transferToEntity(dto.getPost()))
                .user(userDtoToUserTransfer.transferToEntity(dto.getUser()))
                .build();
    }
}
