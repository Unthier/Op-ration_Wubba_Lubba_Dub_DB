package henrotaym.env.scheduler;

import henrotaym.env.enums.ProfileName;
import henrotaym.env.queues.emitters.Emitter;
import henrotaym.env.queues.events.SyncCharactersEvent;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
@Profile(ProfileName.SCHEDULER)
public class SyncCharactersJob {
  private Emitter emitter;

  @Scheduled(timeUnit = TimeUnit.SECONDS, fixedDelay = 30)
  public void handle() {
    SyncCharactersEvent syncCharactersEvent = new SyncCharactersEvent(BigInteger.valueOf(1));
    this.emitter.send(syncCharactersEvent);
    log.info("Récuperez Info");
  }
}
