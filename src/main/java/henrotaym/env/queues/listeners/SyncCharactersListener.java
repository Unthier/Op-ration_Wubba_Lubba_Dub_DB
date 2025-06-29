package henrotaym.env.queues.listeners;

import henrotaym.env.annotations.KafkaRetryableListener;
import henrotaym.env.entities.OriginEntities.CharacterResponsOrigin;
import henrotaym.env.enums.ProfileName;
import henrotaym.env.http.resources.CharacterResource;
import henrotaym.env.mappers.CharacterOriginMapper;
import henrotaym.env.queues.events.SyncCharactersEvent;
import henrotaym.env.services.CharacterService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
@Profile(ProfileName.QUEUE)
public class SyncCharactersListener implements Listener<SyncCharactersEvent> {

  private CharacterService characterService;
  private CharacterOriginMapper characterMapper;

  @Override
  @KafkaRetryableListener(SyncCharactersEvent.EVENT_NAME)
  public void listen(SyncCharactersEvent event) {
    log.info("Charactere");
    CharacterResponsOrigin characterResources = this.characterService.index(event.getPageNumber());
    List<CharacterResource> characterMappers =
        characterResources.getResults().stream()
            .map(c -> this.characterMapper.resource(c))
            .toList();
    for (CharacterResource characterResource : characterMappers) {
      this.characterService.storeOrUpdate(characterResource);
    }
  }
}
