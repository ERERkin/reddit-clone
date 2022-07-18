package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.CommentDtoToCommentTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.CommentToCommentDtoTransfer;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.CommentRepository;
import kg.erkin.springbackend.service.CommentService;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends AbstractService<Comment, CommentDto, CommentRepository,
        CommentToCommentDtoTransfer, CommentDtoToCommentTransfer>
        implements CommentService {
    public CommentServiceImpl(CommentRepository repository, CommentToCommentDtoTransfer transferEntityToDto, CommentDtoToCommentTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Autowired
    private PostService postService;
    @Autowired
    private PostDtoToPostTransfer postDtoToPostTransfer;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoToUserTransfer userDtoToUserTransfer;

    @Override
    public List<CommentDto> getAllByPost(PostDto postDto) {
        List<Comment> commentList = repository.findAllByPost(postDtoToPostTransfer.transferToEntity(postDto));
        return transferEntityToDto.transferToDtoList(commentList);
    }

    @Override
    public List<CommentDto> getAllByPostId(Long postId) {
        PostDto postDto = postService.getById(postId);
        return getAllByPost(postDto);
    }

    @Override
    public List<CommentDto> getAllByUser(UserDto userDto) {
        List<Comment> commentList = repository
                .findAllByUser(userDtoToUserTransfer.transferToEntity(userDto));
        return transferEntityToDto.transferToDtoList(commentList);
    }

    @Override
    public List<CommentDto> getAllByUserUsername(String username) {
        UserDto userDto = userService.getByUsername(username);
        return getAllByUser(userDto);
    }
}
