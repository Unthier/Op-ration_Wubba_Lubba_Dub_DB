package henrotaym.env.entities.OriginEntities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterOrigin {
  private int id;
  private String name;
  private String status;
  private String species;
  private String type;
  private String gender;
  private String image;
  private List<String> episode;
  private String url;
  private String created;
  private Origin origin;
  private LocationOrigin location;
}
