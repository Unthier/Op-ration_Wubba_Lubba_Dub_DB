package henrotaym.env.mappers;

import henrotaym.env.entities.OriginEntities.CharacterOrigin;
import henrotaym.env.enums.CharacterStatusName;
import henrotaym.env.http.resources.CharacterResource;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CharacterOriginMapper {
  public CharacterResource resource(CharacterOrigin character) {
    return new CharacterResource(
        BigInteger.valueOf(character.getId()),
        BigInteger.valueOf(character.getId()),
        character.getName(),
        CharacterStatusName.valueOf(character.getStatus().toString()),
        character.getImage(),
        character.getEpisode().size());
  }

  public henrotaym.env.entities.Character request(
      CharacterResource request, henrotaym.env.entities.Character character) {
    character.setName(request.name());
    character.setApiCharacterId(request.id());
    character.setStatus(request.status());
    character.setImage(request.image());
    character.setEpisodeCount(request.episodeCount());

    return character;
  }
}
