package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class CommentDtoToCommentTransfer extends AbstractTransferDtoToEntity<Comment, CommentDto> {
    private PostDtoToPostTransfer postDtoToPostTransfer;
    private UserDtoToUserTransfer userDtoToUserTransfer;

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
