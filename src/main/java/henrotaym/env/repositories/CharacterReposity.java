package henrotaym.env.repositories;

import henrotaym.env.entities.Character;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterReposity extends JpaRepository<Character, BigInteger> {}
