package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Setter
public class SubredditToSubredditDtoTransfer extends AbstractTransferEntityToDto<Subreddit, SubredditDto> {
    private UserToUserDtoTransfer userToUserDtoTransfer;
    private PostToPostDtoTransfer postToPostDtoTransfer;

    public SubredditToSubredditDtoTransfer() {
        userToUserDtoTransfer = new UserToUserDtoTransfer();
        postToPostDtoTransfer = new PostToPostDtoTransfer(this);
    }

    @Override
    public SubredditDto transferToDto(Subreddit entity) {
        return entity == null ? null : SubredditDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .posts(postToPostDtoTransfer.transferToDtoList(entity.getPosts().stream()
                        .peek(post -> post.setSubreddit(null)).collect(Collectors.toList())))
                .createdDate(entity.getCreatedDate())
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
