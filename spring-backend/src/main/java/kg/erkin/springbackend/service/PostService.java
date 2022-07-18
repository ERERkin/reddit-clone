package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.api.PostRequest;
import kg.erkin.springbackend.model.dto.api.PostResponse;
import kg.erkin.springbackend.service.base.BaseService;

import java.util.List;

public interface PostService extends BaseService<PostDto> {
    List<PostDto> getAllPostsBySubreddit(SubredditDto subredditDto);
    List<PostDto> getAllPostsByUser(UserDto userDto);
    List<PostResponse> getPostResponsesBySubreddit(Long subredditId);
    List<PostResponse> getPostResponsesByUsername(String username);
    PostDto saveRequest(PostRequest postRequest);
    PostResponse getResponseById(Long id);
}
