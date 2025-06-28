package henrotaym.env.entities.OriginEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoOrigin {
  private int count;
  private int pages;
  private String next;
  private String prev;
}
