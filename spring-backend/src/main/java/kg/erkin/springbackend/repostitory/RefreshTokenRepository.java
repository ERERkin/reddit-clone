package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.RefreshToken;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends BaseRepository<RefreshToken> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
