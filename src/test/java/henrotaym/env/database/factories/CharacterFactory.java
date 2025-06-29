package henrotaym.env.database.factories;

import henrotaym.env.entities.Character;
import henrotaym.env.enums.CharacterStatusName;
import java.math.BigInteger;
import net.datafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CharacterFactory extends EntityFactory<henrotaym.env.entities.Character> {

  public CharacterFactory(Faker faker, JpaRepository<Character, BigInteger> repository) {
    super(faker, repository);
  }

  @Override
  protected Character entity() {
    return new Character();
  }

  @Override
  protected void attributes(Character entity) {
    entity.setName(this.faker.rickAndMorty().character());
    entity.setImage(this.faker.internet().image());
    entity.setApiCharacterId(BigInteger.valueOf(454));
    entity.setEpisodeCount(0);
    entity.setStatus(CharacterStatusName.Alive);
  }
}
