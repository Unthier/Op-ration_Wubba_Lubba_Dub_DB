package henrotaym.env.entities.OriginEntities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeResponsOrigin {
  private InfoOrigin info;
  private List<EpisodeOrigin> results;
}
