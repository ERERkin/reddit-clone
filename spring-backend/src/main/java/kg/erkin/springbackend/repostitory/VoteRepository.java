package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends BaseRepository<Vote> {
//    Optional<Vote> findTopByPostAndUserOrderOrderByVoteIdDesc(Post post, User currentUser);
}
