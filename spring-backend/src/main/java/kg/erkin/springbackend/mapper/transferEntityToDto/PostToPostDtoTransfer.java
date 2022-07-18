package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostToPostDtoTransfer extends AbstractTransferEntityToDto<Post, PostDto> {
    @Autowired
    UserToUserDtoTransfer userToUserDtoTransfer;
    @Autowired
    SubredditToSubredditDtoTransfer subredditToSubredditDtoTransfer;

    @Override
    public PostDto transferToDto(Post entity) {
        return entity == null ? null : PostDto.builder()
                .postId(entity.getPostId())
                .postName(entity.getPostName())
                .description(entity.getDescription())
                .url(entity.getUrl())
                .voteCount(entity.getVoteCount())
                .createdDate(entity.getCreatedDate())
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .subreddit(subredditToSubredditDtoTransfer.transferToDto(entity.getSubreddit()))
                .build();
    }
}
