package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findAllByUser(User user);
}
