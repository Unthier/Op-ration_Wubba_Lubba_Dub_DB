package henrotaym.env.repositories;

import henrotaym.env.entities.Episode;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, BigInteger> {}
