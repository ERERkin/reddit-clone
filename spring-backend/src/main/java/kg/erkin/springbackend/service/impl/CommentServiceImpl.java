package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.CommentDtoToCommentTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.UserDtoToUserTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.CommentToCommentDtoTransfer;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.service.CommentEntityService;
import kg.erkin.springbackend.service.CommentService;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.UserService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends AbstractService<CommentEntityService, Comment, CommentDto, CommentToCommentDtoTransfer, CommentDtoToCommentTransfer>
        implements CommentService {
    public CommentServiceImpl(CommentEntityService entityService, CommentToCommentDtoTransfer transferEntityToDto, CommentDtoToCommentTransfer transferDtoToEntity) {
        super(entityService, transferEntityToDto, transferDtoToEntity);
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
    public List<CommentDto> getAllByPostId(Long postId) {
        PostDto postDto = postService.getById(postId);
        List<Comment> commentList = entityService
                .getAllByPost(postDtoToPostTransfer.transferToEntity(postDto));
        return transferEntityToDto.transferToDtoList(commentList);
    }

    @Override
    public List<CommentDto> getAllByUserUsername(String username) {
        UserDto userDto = userService.getByUsername(username);
        List<Comment> commentList = entityService
                .getAllByUser(userDtoToUserTransfer.transferToEntity(userDto));
        return transferEntityToDto.transferToDtoList(commentList);
    }
}
