package kg.erkin.springbackend.mapper.transferDtoToEntity;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import org.springframework.stereotype.Component;

@Component
public class VoteDtoToVoteTransfer extends AbstractTransferDtoToEntity<Vote, VoteDto> {
    @Override
    public Vote transferToEntity(VoteDto dto) {
        return null;
    }
}
