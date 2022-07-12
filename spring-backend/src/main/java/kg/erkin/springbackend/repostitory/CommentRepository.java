package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);

    List<Comment> findAllByUser(User user);
}
