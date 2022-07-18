package kg.erkin.springbackend.mapper.transferDtoToResponse;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import kg.erkin.springbackend.mapper.transferDtoToResponse.base.AbstractTransferDtoToResponse;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.PostResponse;
import kg.erkin.springbackend.model.enums.VoteType;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.CommentService;
import kg.erkin.springbackend.service.VoteService;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static kg.erkin.springbackend.model.enums.VoteType.DOWNVOTE;
import static kg.erkin.springbackend.model.enums.VoteType.UPVOTE;

@Component
@Setter
public class PostDtoToPostResponseTransfer extends AbstractTransferDtoToResponse<PostDto, PostResponse> {
    private CommentService commentService;
    private AuthService authService;
    private VoteService voteService;

    @Override
    public PostResponse transferToResponse(PostDto dto) {
        return PostResponse.builder()
                .id(dto.getPostId())
                .subredditName(dto.getSubreddit().getName())
                .userName(dto.getUser().getUsername())
                .commentCount(commentCount(dto.getPostId()))
                .duration(getDuration(dto))
                .upVote(isPostUpVoted(dto))
                .downVote(isPostDownVoted(dto))
                .build();
    }

    Integer commentCount(Long postId) {
        return commentService.getAllByPostId(postId).size();
    }

    String getDuration(PostDto post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

    boolean isPostUpVoted(PostDto post) {
        return checkVoteType(post, UPVOTE);
    }

    boolean isPostDownVoted(PostDto post) {
        return checkVoteType(post, DOWNVOTE);
    }

    private boolean checkVoteType(PostDto post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            VoteDto voteDto = voteService.getTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
            return Objects.nonNull(voteDto);
        }
        return false;
    }
}
