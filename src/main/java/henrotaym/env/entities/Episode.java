package henrotaym.env.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "episodes")
public class Episode {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "api_episode_id")
  private BigInteger apiEpisodeId;

  private String name;
  private String episodeCode;

  @Transient private List<String> characters;
}
