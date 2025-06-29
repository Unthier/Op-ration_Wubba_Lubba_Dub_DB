package henrotaym.env.entities.OriginEntities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeOrigin {
  private int id;
  private String name;
  private String air_date;
  private String episode;
  private List<String> characters;
  private String url;
  private String created;
}
