package kg.erkin.springbackend.mapper.TransferDtoToEntity;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Subreddit;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class SubredditDtoToSubredditTransfer extends AbstractTransferDtoToEntity<Subreddit, SubredditDto> {
    private UserDtoToUserTransfer userDtoToUserTransfer;
    private PostDtoToPostTransfer postDtoToPostTransfer;

    @Override
    public Subreddit transferToEntity(SubredditDto dto) {
        return dto == null ? null : Subreddit.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .posts(postDtoToPostTransfer.transferToEntityList(dto.getPosts()))
                .user(userDtoToUserTransfer.transferToEntity(dto.getUser()))
                .build();
    }
}
