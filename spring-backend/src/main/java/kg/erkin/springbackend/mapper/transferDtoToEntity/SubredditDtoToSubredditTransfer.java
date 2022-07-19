package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.service.AuthService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubredditDtoToSubredditTransfer extends AbstractTransferDtoToEntity<Subreddit, SubredditDto> {
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;
    @Autowired
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
