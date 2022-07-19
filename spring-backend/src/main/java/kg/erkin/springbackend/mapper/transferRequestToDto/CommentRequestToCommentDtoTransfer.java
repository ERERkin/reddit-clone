package kg.erkin.springbackend.mapper.transferRequestToDto;

import kg.erkin.springbackend.mapper.transferRequestToDto.base.AbstractTransferRequestToDto;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.api.CommentRequest;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.PostService;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CommentRequestToCommentDtoTransfer
        extends AbstractTransferRequestToDto<CommentDto, CommentRequest> {
    private final AuthService authService;
    private final PostService postService;

    public CommentRequestToCommentDtoTransfer(AuthService authService, PostService postService) {
        this.authService = authService;
        this.postService = postService;
    }

    @Override
    public CommentDto transferToDto(CommentRequest request) {
        return CommentDto.builder()
                .id(request.getId())
                .text(request.getText())
                .createdDate(Instant.now())
                .post(postService.getById(request.getPostId()))
                .user(authService.getCurrentUser())
                .build();
    }
}
