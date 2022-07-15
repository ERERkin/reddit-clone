package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
    List<Comment> findAllByPost(Post post);

    List<Comment> findAllByUser(User user);
}
