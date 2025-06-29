package henrotaym.env.Tests.Features.http.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import henrotaym.env.ApplicationTest;
import henrotaym.env.database.factories.CharacterFactory;
import henrotaym.env.entities.Character;
import henrotaym.env.entities.OriginEntities.EpisodeResponsOrigin;
import henrotaym.env.http.resources.EpisodeResource;
import henrotaym.env.mappers.EpisodeOriginMapper;
import henrotaym.env.repositories.CharacterRepository;
import henrotaym.env.services.EpisodeService;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EpisodeServiceFeatureTest extends ApplicationTest {
  @Autowired EpisodeService episodeService;

  @Autowired CharacterFactory characterFactory;

  @Autowired EpisodeOriginMapper episodeOriginMapper;

  @Autowired CharacterRepository characterRepository;

  @Test
  public void it_Number_Episode_Add_Function() {
    Character character = this.characterFactory.create();
    EpisodeResponsOrigin episodeResponsOrigin = this.episodeService.index(BigInteger.valueOf(2));
    List<EpisodeResource> episodeResources =
        episodeResponsOrigin.getResults().stream()
            .map(e -> this.episodeOriginMapper.resource(e))
            .toList();
    for (EpisodeResource episodeResource : episodeResources) {
      this.episodeService.storeOrUpdate(episodeResource);
    }

    Character newCharacter = this.characterRepository.findById(character.getId()).get();

    assertEquals(character.getId(), newCharacter.getId());
    assertEquals(character.getApiCharacterId(), newCharacter.getApiCharacterId());
    assertEquals(character.getEpisodeCount(), newCharacter.getEpisodeCount() - 1);
  }
}
