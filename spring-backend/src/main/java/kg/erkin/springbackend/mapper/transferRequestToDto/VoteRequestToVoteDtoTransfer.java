package kg.erkin.springbackend.mapper.transferRequestToDto;

import kg.erkin.springbackend.mapper.transferRequestToDto.base.AbstractTransferRequestToDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.PostService;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VoteRequestToVoteDtoTransfer extends AbstractTransferRequestToDto<VoteDto, VoteRequest> {
    private final PostService postService;
    private final AuthService authService;

    public VoteRequestToVoteDtoTransfer(@Lazy PostService postService,@Lazy AuthService authService) {
        this.postService = postService;
        this.authService = authService;
    }

    @Override
    public VoteDto transferToDto(VoteRequest request) {
        return VoteDto.builder()
                .voteType(request.getVoteType())
                .post(postService.getById(request.getPostId()))
                .user(authService.getCurrentUser())
                .build();
    }
}
