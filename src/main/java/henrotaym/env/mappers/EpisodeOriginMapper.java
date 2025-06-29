package henrotaym.env.mappers;

import henrotaym.env.entities.Episode;
import henrotaym.env.entities.OriginEntities.EpisodeOrigin;
import henrotaym.env.http.resources.EpisodeResource;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EpisodeOriginMapper {
  public EpisodeResource resource(EpisodeOrigin episodeOrigin) {
    return new EpisodeResource(
        BigInteger.valueOf(episodeOrigin.getId()),
        BigInteger.valueOf(episodeOrigin.getId()),
        episodeOrigin.getName(),
        episodeOrigin.getEpisode(),
        episodeOrigin.getCharacters());
  }

  public Episode request(EpisodeResource request, Episode episode) {
    episode.setName(request.name());
    episode.setApiEpisodeId(request.id());
    episode.setEpisodeCode(request.episodeCode());

    return episode;
  }
}
