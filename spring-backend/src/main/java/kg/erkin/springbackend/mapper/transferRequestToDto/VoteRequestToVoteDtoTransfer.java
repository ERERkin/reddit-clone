package kg.erkin.springbackend.mapper.transferRequestToDto;

import kg.erkin.springbackend.mapper.transferRequestToDto.base.AbstractTransferRequestToDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.PostService;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class VoteRequestToVoteDtoTransfer extends AbstractTransferRequestToDto<VoteDto, VoteRequest> {
    private PostService postService;
    private AuthService authService;

    @Override
    public VoteDto transferToDto(VoteRequest request) {
        return VoteDto.builder()
                .voteType(request.getVoteType())
                .post(postService.getById(request.getPostId()))
                .user(authService.getCurrentUser())
                .build();
    }
}
