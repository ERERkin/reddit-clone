package kg.erkin.springbackend.repostitory;

import kg.erkin.springbackend.model.entity.VerificationToken;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends BaseRepository<VerificationToken> {
    Optional<VerificationToken> findByToken(String token);
}
