package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class VoteDtoToVoteTransfer extends AbstractTransferDtoToEntity<Vote, VoteDto> {
    private PostDtoToPostTransfer postDtoToPostTransfer;
    private UserDtoToUserTransfer userDtoToUserTransfer;

    @Override
    public Vote transferToEntity(VoteDto dto) {
        return dto == null ? null : Vote.builder()
                .voteId(dto.getVoteId())
                .voteType(dto.getVoteType())
                .post(postDtoToPostTransfer.transferToEntity(dto.getPost()))
                .user(userDtoToUserTransfer.transferToEntity(dto.getUser()))
                .build();
    }
}
