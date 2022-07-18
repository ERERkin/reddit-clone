package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.service.base.BaseEntityService;

import java.util.List;

public interface PostEntityService extends BaseEntityService<Post> {
    List<Post> getAllPostsBySubreddit(Subreddit subreddit);
    List<Post> getAllPostsByUser(User user);
}
