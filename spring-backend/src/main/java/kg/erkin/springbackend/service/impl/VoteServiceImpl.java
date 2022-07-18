package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.VoteDtoToVoteTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.PostToPostDtoTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.VoteToVoteDtoTransfer;
import kg.erkin.springbackend.mapper.transferRequestToDto.VoteRequestToVoteDtoTransfer;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.service.AuthService;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.VoteEntityService;
import kg.erkin.springbackend.service.VoteService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static kg.erkin.springbackend.model.enums.VoteType.UPVOTE;

@Service
public class VoteServiceImpl extends AbstractService<VoteEntityService, Vote, VoteDto,
        VoteToVoteDtoTransfer, VoteDtoToVoteTransfer>
        implements VoteService {

    public VoteServiceImpl(VoteEntityService entityService, VoteToVoteDtoTransfer transferToDto, VoteDtoToVoteTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
    }

    @Autowired
    private PostDtoToPostTransfer postDtoToPostTransfer;
    @Autowired
    private PostToPostDtoTransfer postToPostDtoTransfer;
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;
    @Autowired
    private PostService postService;
    @Autowired
    private AuthService authService;
    @Autowired
    private VoteRequestToVoteDtoTransfer voteRequestToVoteDtoTransfer;

    @Transactional
    @Override
    public void vote(VoteRequest voteRequest) {
        PostDto postDto = postService.getById(voteRequest.getPostId());
        Post post = postDtoToPostTransfer.transferToEntity(postDto);
        User user = userDtoToUserTransfer.transferToEntity(authService.getCurrentUser());
        VoteDto voteByPostAndUser = transferEntityToDto.transferToDto(
                entityService.getTopByPostAndUserOrderByVoteIdDesc(post, user));
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

    @Override
    public VoteDto getTopByPostAndUserOrderByVoteIdDesc(PostDto postDto, UserDto userDto) {
        Post post = postDtoToPostTransfer.transferToEntity(postDto);
        User user = userDtoToUserTransfer.transferToEntity(userDto);
        Vote vote = entityService.getTopByPostAndUserOrderByVoteIdDesc(post, user);
        return transferEntityToDto.transferToDto(vote);
    }
}
