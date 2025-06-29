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
import jakarta.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class EpisodeServiceFeatureTest extends ApplicationTest {
  @Autowired EpisodeService episodeService;

  @Autowired CharacterFactory characterFactory;

  @Autowired EpisodeOriginMapper episodeOriginMapper;

  @Autowired CharacterRepository characterRepository;

  @Autowired EntityManager entityManager;

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

    entityManager.flush();
    entityManager.clear();
    Character newCharacter = this.characterRepository.findById(character.getId()).get();
    log.info(newCharacter.getEpisodeCount().toString());
    assertEquals(character.getId(), newCharacter.getId());
    assertEquals(character.getApiCharacterId(), newCharacter.getApiCharacterId());
    assertEquals(character.getEpisodeCount(), newCharacter.getEpisodeCount());
  }

  @Test
  public void it_Character_Not_Exected_Function() {
    var characterNumber = this.characterRepository.count();
    EpisodeResponsOrigin episodeResponsOrigin = this.episodeService.index(BigInteger.valueOf(2));
    List<EpisodeResource> episodeResources =
        episodeResponsOrigin.getResults().stream()
            .map(e -> this.episodeOriginMapper.resource(e))
            .toList();
    for (EpisodeResource episodeResource : episodeResources) {
      this.episodeService.storeOrUpdate(episodeResource);
    }
    var newCharacter = this.characterRepository.count();

    assertEquals(characterNumber, newCharacter);
  }
}
