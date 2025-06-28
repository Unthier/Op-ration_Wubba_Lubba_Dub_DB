package henrotaym.env.entities.OriginEntities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CharacterResponsOrigin {

  private InfoOrigin info;
  private List<CharacterOrigin> results;
}
