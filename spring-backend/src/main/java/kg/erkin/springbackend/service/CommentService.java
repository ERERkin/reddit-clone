package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.api.CommentRequest;
import kg.erkin.springbackend.model.dto.api.CommentResponse;
import kg.erkin.springbackend.service.base.BaseService;

import java.util.List;

public interface CommentService extends BaseService<CommentDto> {
    List<CommentDto> getAllByPostId(Long postId);
    List<CommentDto> getAllByUserUsername(String username);
    CommentResponse save(CommentRequest commentRequest);
    List<CommentResponse> getResponseListByPostId(Long postId);
    List<CommentResponse> getResponseListByUserUsername(String username);
}
