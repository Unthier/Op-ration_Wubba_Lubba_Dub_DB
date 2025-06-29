package henrotaym.env.mappers;

import henrotaym.env.entities.Episode;
import henrotaym.env.http.resources.EpisodeResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EpisodeMapper {
  public EpisodeResource resource(Episode episode) {
    return new EpisodeResource(
        episode.getId(),
        episode.getId(),
        episode.getName(),
        episode.getEpisodeCode(),
        episode.getCharacters());
  }

  public Episode request(EpisodeResource request, Episode episode) {
    episode.setName(request.name());
    episode.setApiEpisodeId(request.id());
    episode.setEpisodeCode(request.episodeCode());
    episode.setCharacters(request.characters());

    return episode;
  }
}
