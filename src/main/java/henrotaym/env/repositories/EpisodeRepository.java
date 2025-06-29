package henrotaym.env.repositories;

import henrotaym.env.entities.Episode;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EpisodeRepository
    extends JpaRepository<Episode, BigInteger>, QuerydslPredicateExecutor<Episode> {
  Optional<Episode> findByApiEpisodeId(BigInteger apiEpisodeId);
}
