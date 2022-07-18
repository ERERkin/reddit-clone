package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.service.base.BaseEntityService;

import java.util.List;

public interface CommentEntityService extends BaseEntityService<Comment> {
    List<Comment> getAllByPost(Post post);
    List<Comment> getAllByUser(User user);
}
