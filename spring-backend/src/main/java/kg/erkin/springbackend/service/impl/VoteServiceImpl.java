package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.VoteDtoToVoteTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.VoteToVoteDtoTransfer;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.repostitory.VoteRepository;
import kg.erkin.springbackend.service.VoteService;
import kg.erkin.springbackend.service.base.AbstractService;

public class VoteServiceImpl extends AbstractService<Vote, VoteDto, VoteRepository,
        VoteToVoteDtoTransfer, VoteDtoToVoteTransfer>
        implements VoteService {
    public VoteServiceImpl(VoteRepository repository, VoteToVoteDtoTransfer transferEntityToDto, VoteDtoToVoteTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
}
