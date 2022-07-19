package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.entity.Post;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Setter
public class PostDtoToPostTransfer extends AbstractTransferDtoToEntity<Post, PostDto> {
    private final UserDtoToUserTransfer userDtoToUserTransfer;
    private final SubredditDtoToSubredditTransfer subredditDtoToSubredditTransfer;

    public PostDtoToPostTransfer() {
        userDtoToUserTransfer = new UserDtoToUserTransfer();
        subredditDtoToSubredditTransfer = new SubredditDtoToSubredditTransfer();
    }

    public PostDtoToPostTransfer(SubredditDtoToSubredditTransfer subredditDtoToSubredditTransfer) {
        userDtoToUserTransfer = new UserDtoToUserTransfer();
        this.subredditDtoToSubredditTransfer = subredditDtoToSubredditTransfer;
    }

    @Override
    public Post transferToEntity(PostDto dto) {
        return dto == null ? null : Post.builder()
                .postId(dto.getPostId())
                .postName(dto.getPostName())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .voteCount(dto.getVoteCount())
                .createdDate(dto.getCreatedDate())
                .user(userDtoToUserTransfer.transferToEntity(dto.getUser()))
                .subreddit(subredditDtoToSubredditTransfer.transferToEntity(dto.getSubreddit()))
                .build();
    }
}
