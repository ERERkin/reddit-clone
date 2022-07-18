package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.service.base.BaseService;

import java.util.List;

public interface CommentService extends BaseService<CommentDto> {
    List<CommentDto> getAllByPost(PostDto postDto);
    List<CommentDto> getAllByPostId(Long postId);
    List<CommentDto> getAllByUser(UserDto userDto);
    List<CommentDto> getAllByUserUsername(String username);
}
