package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
public class SubredditToSubredditDtoTransfer extends AbstractTransferEntityToDto<Subreddit, SubredditDto> {
    @Autowired
    private UserToUserDtoTransfer userToUserDtoTransfer;
    @Autowired
    private PostToPostDtoTransfer postToPostDtoTransfer;

    @Override
    public SubredditDto transferToDto(Subreddit entity) {
        return entity == null ? null : SubredditDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .posts(postToPostDtoTransfer.transferToDtoList(entity.getPosts()))
                .createdDate(entity.getCreatedDate())
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
