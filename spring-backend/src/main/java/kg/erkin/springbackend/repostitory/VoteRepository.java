package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
//    Optional<Vote> findTopByPostAndUserOrderOrderByVoteIdDesc(Post post, User currentUser);
}
