package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
}
