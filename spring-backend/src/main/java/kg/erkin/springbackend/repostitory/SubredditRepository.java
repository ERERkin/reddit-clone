package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubredditRepository extends BaseRepository<Subreddit> {
    Optional<Subreddit> findByName(String subredditName);

    @Query("select count(p) from Post p where p.subreddit.id = :subreddit")
    Integer findPostsCount(@Param("subreddit") Subreddit subreddit);
}
