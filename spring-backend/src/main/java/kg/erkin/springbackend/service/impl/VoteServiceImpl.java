package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.VoteDtoToVoteTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.VoteToVoteDtoTransfer;
import kg.erkin.springbackend.mapper.transferRequestToDto.VoteRequestToVoteDtoTransfer;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.repostitory.VoteRepository;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.VoteService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static kg.erkin.springbackend.model.enums.VoteType.UPVOTE;

@Service
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
    @Autowired
    private PostService postService;
    @Autowired
    private AuthService authService;
    @Autowired
    private VoteRequestToVoteDtoTransfer voteRequestToVoteDtoTransfer;

    @Override
    public VoteDto getTopByPostAndUserOrderByVoteIdDesc(PostDto postDto, UserDto userDto) {
        Post post = postDtoToPostTransfer.transferToEntity(postDto);
        User user = userDtoToUserTransfer.transferToEntity(userDto);
        Vote vote = repository.findTopByPostAndUserOrderByVoteIdDesc(post, user).orElse(null);
        return transferEntityToDto.transferToDto(vote);
    }

    @Transactional
    @Override
    public void vote(VoteRequest voteRequest) {
        PostDto postDto = postService.getById(voteRequest.getPostId());
        VoteDto voteByPostAndUser = getTopByPostAndUserOrderByVoteIdDesc(postDto, authService.getCurrentUser());
        if (voteByPostAndUser != null &&
                voteByPostAndUser.getVoteType()
                        .equals(voteRequest.getVoteType())){
            throw new RuntimeException("You have already "
                    + voteRequest.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteRequest.getVoteType())){
            postDto.setVoteCount(postDto.getVoteCount() + 1);
        }else {
            postDto.setVoteCount(postDto.getVoteCount() - 1);
        }

        postService.save(postDto);
        save(voteRequestToVoteDtoTransfer.transferToDto(voteRequest));
    }
}
