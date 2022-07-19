package kg.erkin.springbackend.mapper.transferDtoToResponse;

import kg.erkin.springbackend.mapper.transferDtoToResponse.base.AbstractTransferDtoToResponse;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.api.CommentResponse;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToCommentResponseTransfer
        extends AbstractTransferDtoToResponse<CommentDto, CommentResponse> {

    @Override
    public CommentResponse transferToResponse(CommentDto dto) {
        return CommentResponse.builder()
                .id(dto.getId())
                .postId(dto.getPost().getPostId())
                .createdDate(dto.getCreatedDate())
                .text(dto.getText())
                .username(dto.getUser().getUsername())
                .build();
    }
}
