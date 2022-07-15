package kg.erkin.springbackend.mapper.TransferEntityToDto;

import kg.erkin.springbackend.mapper.TransferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import org.springframework.stereotype.Component;

@Component
public class VoteToVoteDtoTransfer extends AbstractTransferEntityToDto<Vote, VoteDto> {
    @Override
    public VoteDto transferToDto(Vote entity) {
        return null;
    }
}
