package henrotaym.env.mappers;

import henrotaym.env.entities.Character;
import henrotaym.env.http.resources.CharacterResource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class ResourceMapper {
  // private final  studioMapper;
  private final CharacterMapper characterMapper;

  public CharacterResource gameResource(Character character) {
    CharacterResource gameResource = this.characterMapper.resource(character);

    return gameResource;
  }

  //   public StudioResource studioResource(Studio studio) {
  //     List<GameResource> games =
  //         studio.getGames().stream().map(g -> this.gameMapper.resource(g)).toList();
  //     StudioResource studioResource = this.studioMapper.resource(studio);
  //     studioResource.setGames(games);

  //     return studioResource;
  //   }
}
