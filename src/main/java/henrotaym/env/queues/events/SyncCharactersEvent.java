package henrotaym.env.queues.events;

import henrotaym.env.enums.EventName;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SyncCharactersEvent implements Event {
  private BigInteger pageNumber;

  public static final String EVENT_NAME = EventName.CHARACTER_CHECKED;

  @Override
  public String eventName() {
    return EVENT_NAME;
  }
}
