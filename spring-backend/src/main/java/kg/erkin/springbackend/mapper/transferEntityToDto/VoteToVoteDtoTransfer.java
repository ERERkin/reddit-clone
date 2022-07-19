package kg.erkin.springbackend.mapper.transferEntityToDto;

import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
public class VoteToVoteDtoTransfer extends AbstractTransferEntityToDto<Vote, VoteDto> {
    private PostToPostDtoTransfer postToPostDtoTransfer;
    private UserToUserDtoTransfer userToUserDtoTransfer;

    @Override
    public VoteDto transferToDto(Vote entity) {
        return entity == null ? null : VoteDto.builder()
                .voteId(entity.getVoteId())
                .voteType(entity.getVoteType())
                .post(postToPostDtoTransfer.transferToDto(entity.getPost()))
                .user(userToUserDtoTransfer.transferToDto(entity.getUser()))
                .build();
    }
}
