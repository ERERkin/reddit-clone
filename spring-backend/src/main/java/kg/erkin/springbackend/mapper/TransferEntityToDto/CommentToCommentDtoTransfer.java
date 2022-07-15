package kg.erkin.springbackend.mapper.TransferEntityToDto;

import kg.erkin.springbackend.mapper.TransferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDtoTransfer extends AbstractTransferEntityToDto<Comment, CommentDto> {
    @Override
    public CommentDto transferToDto(Comment entity) {
        return null;
    }
}
