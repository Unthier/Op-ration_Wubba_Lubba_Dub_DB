package henrotaym.env.mappers;

import henrotaym.env.entities.Character;
import henrotaym.env.entities.Episode;
import henrotaym.env.http.resources.CharacterResource;
import henrotaym.env.http.resources.EpisodeResource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class ResourceMapper {
  private final EpisodeMapper episodeMapper;
  private final CharacterMapper characterMapper;

  public CharacterResource gameResource(Character character) {
    CharacterResource gameResource = this.characterMapper.resource(character);

    return gameResource;
  }

  public EpisodeResource studioResource(Episode episode) {
    EpisodeResource episodeResources = this.episodeMapper.resource(episode);

    return episodeResources;
  }
}
