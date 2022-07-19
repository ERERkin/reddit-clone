package kg.erkin.springbackend.mapper.transferRequestToDto;

import kg.erkin.springbackend.mapper.transferRequestToDto.base.AbstractTransferRequestToDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.api.PostRequest;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.SubredditService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PostRequestToPostDtoTransfer extends AbstractTransferRequestToDto<PostDto, PostRequest> {
    @Autowired
    private SubredditService subredditService;
    @Autowired
    private AuthService authService;

    @Override
    public PostDto transferToDto(PostRequest request) {
        return PostDto.builder()
                .postId(request.getPostId())
                .postName(request.getPostName())
                .url(request.getUrl())
                .description(request.getDescription())
                .subreddit(subredditService.getByName(request.getSubredditName()))
                .user(authService.getCurrentUser())
                .voteCount(0)
                .createdDate(Instant.now())
                .build();
    }
}
