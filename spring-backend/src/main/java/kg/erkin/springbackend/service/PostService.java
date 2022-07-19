package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.UserDto;
import kg.erkin.springbackend.model.dto.api.PostRequest;
import kg.erkin.springbackend.model.dto.api.PostResponse;
import kg.erkin.springbackend.model.dto.api.SubredditResponse;
import kg.erkin.springbackend.service.base.BaseService;

import java.util.List;

public interface PostService extends BaseService<PostDto> {
    List<PostResponse> getPostResponsesBySubreddit(Long subredditId);
    List<PostResponse> getPostResponsesByUsername(String username);
    PostDto save(PostRequest postRequest);
    PostResponse getResponseById(Long id);
    List<PostResponse> getResponseList();
}
