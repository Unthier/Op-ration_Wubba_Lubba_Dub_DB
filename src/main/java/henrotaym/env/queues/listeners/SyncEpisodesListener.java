package henrotaym.env.queues.listeners;

import henrotaym.env.annotations.KafkaRetryableListener;
import henrotaym.env.entities.OriginEntities.EpisodeResponsOrigin;
import henrotaym.env.enums.ProfileName;
import henrotaym.env.http.resources.EpisodeResource;
import henrotaym.env.mappers.EpisodeOriginMapper;
import henrotaym.env.queues.events.SyncEpisodesEvent;
import henrotaym.env.services.EpisodeService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
@Profile(ProfileName.QUEUE)
public class SyncEpisodesListener implements Listener<SyncEpisodesEvent> {

  private EpisodeService episodeService;
  private EpisodeOriginMapper episodeOriginMapper;

  @Override
  @KafkaRetryableListener(SyncEpisodesEvent.EVENT_NAME)
  public void listen(SyncEpisodesEvent event) {
    log.info("episode");
    EpisodeResponsOrigin episodeResponsOrigin = this.episodeService.index(event.getPageNumber());
    List<EpisodeResource> episodeResources =
        episodeResponsOrigin.getResults().stream()
            .map(e -> this.episodeOriginMapper.resource(e))
            .toList();
    for (EpisodeResource episodeResource : episodeResources) {
      this.episodeService.storeOrUpdate(episodeResource);
    }
  }
}
