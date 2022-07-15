package kg.erkin.springbackend.mapper.TransferDtoToEntity;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToCommentTransfer extends AbstractTransferDtoToEntity<Comment, CommentDto> {
    @Override
    public Comment transferToEntity(CommentDto dto) {
        return Comment.builder()
                .build();
    }
}
