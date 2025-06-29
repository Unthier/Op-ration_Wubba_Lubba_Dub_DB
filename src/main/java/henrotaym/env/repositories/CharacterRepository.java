package henrotaym.env.repositories;

import henrotaym.env.entities.Character;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CharacterRepository
    extends JpaRepository<Character, BigInteger>, QuerydslPredicateExecutor<Character> {
  Optional<Character> findByApiCharacterId(BigInteger apiCharacterId);
}
