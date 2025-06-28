package henrotaym.env.mappers;

import henrotaym.env.http.resources.CharacterResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CharacterMapper {
  public CharacterResource resource(henrotaym.env.entities.Character character) {
    return new CharacterResource(
        character.getId(),
        character.getId(),
        character.getName(),
        character.getStatus(),
        character.getImage(),
        character.getEpisodeCount());
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
