package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.SubredditDtoToSubredditTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferDtoToResponse.PostDtoToPostResponseTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.PostToPostDtoTransfer;
import kg.erkin.springbackend.mapper.transferRequestToDto.PostRequestToPostDtoTransfer;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.api.PostRequest;
import kg.erkin.springbackend.model.dto.api.PostResponse;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.PostRepository;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.SubredditService;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl extends AbstractService<Post, PostDto, PostRepository,
        PostToPostDtoTransfer, PostDtoToPostTransfer>
        implements PostService {
    public PostServiceImpl(PostRepository repository, PostToPostDtoTransfer transferEntityToDto, PostDtoToPostTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Autowired
    private PostDtoToPostResponseTransfer postDtoToPostResponseTransfer;
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;
    @Autowired
    private SubredditService subredditService;
    @Autowired
    private SubredditDtoToSubredditTransfer subredditDtoToSubredditTransfer;
    @Autowired
    private UserService userService;
    @Autowired
    private PostRequestToPostDtoTransfer postRequestToPostDtoTransfer;

    @Transactional(readOnly = true)
    public List<PostDto> getAllPostsBySubreddit(SubredditDto subredditDto) {
        Subreddit subreddit = subredditDtoToSubredditTransfer.transferToEntity(subredditDto);
        List<Post> postList = repository.findAllBySubreddit(subreddit);
        return transferEntityToDto.transferToDtoList(postList);
    }

    @Transactional(readOnly = true)
    public List<PostDto> getAllPostsByUser(UserDto userDto) {
        User user = userDtoToUserTransfer.transferToEntity(userDto);
        List<Post> postList = repository.findAllByUser(user);
        return transferEntityToDto.transferToDtoList(postList);
    }

    public List<PostResponse> getPostResponsesBySubreddit(Long subredditId) {
        SubredditDto subredditDto = subredditService.getById(subredditId);
        List<PostDto> postDtoList = getAllPostsBySubreddit(subredditDto);
        return postDtoList.stream()
                .map(post -> postDtoToPostResponseTransfer.transferToResponse(post))
                .collect(Collectors.toList());
    }

    public List<PostResponse> getPostResponsesByUsername(String username) {
        UserDto user = userService.getByUsername(username);
        List<PostDto> postDtoList = getAllPostsByUser(user);
        return postDtoList.stream()
                .map(post -> postDtoToPostResponseTransfer.transferToResponse(post))
                .collect(Collectors.toList());

    }

    public PostDto saveRequest(PostRequest postRequest){
        PostDto postDto = postRequestToPostDtoTransfer.transferToDto(postRequest);
        return save(postDto);
    }

    @Override
    public PostResponse getResponseById(Long id) {
        PostDto postDto = getById(id);
        return postDtoToPostResponseTransfer.transferToResponse(postDto);
    }

}