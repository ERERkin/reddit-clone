package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.VoteDtoToVoteTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.VoteToVoteDtoTransfer;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.repostitory.VoteRepository;
import kg.erkin.springbackend.service.VoteService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

public class VoteServiceImpl extends AbstractService<Vote, VoteDto, VoteRepository,
        VoteToVoteDtoTransfer, VoteDtoToVoteTransfer>
        implements VoteService {
    public VoteServiceImpl(VoteRepository repository, VoteToVoteDtoTransfer transferEntityToDto, VoteDtoToVoteTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
    @Autowired
    private PostDtoToPostTransfer postDtoToPostTransfer;
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;

    @Override
    public VoteDto getTopByPostAndUserOrderByVoteIdDesc(PostDto postDto, UserDto userDto) {
        Post post = postDtoToPostTransfer.transferToEntity(postDto);
        User user = userDtoToUserTransfer.transferToEntity(userDto);
        Vote vote = repository.findTopByPostAndUserOrderByVoteIdDesc(post, user).orElse(null);
        return transferEntityToDto.transferToDto(vote);
    }
}
