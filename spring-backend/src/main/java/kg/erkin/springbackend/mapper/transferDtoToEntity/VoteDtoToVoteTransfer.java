package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VoteDtoToVoteTransfer extends AbstractTransferDtoToEntity<Vote, VoteDto> {
    private final PostDtoToPostTransfer postDtoToPostTransfer;
    private final UserDtoToUserTransfer userDtoToUserTransfer;

    public VoteDtoToVoteTransfer(@Lazy PostDtoToPostTransfer postDtoToPostTransfer,@Lazy UserDtoToUserTransfer userDtoToUserTransfer) {
        this.postDtoToPostTransfer = postDtoToPostTransfer;
        this.userDtoToUserTransfer = userDtoToUserTransfer;
    }

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
