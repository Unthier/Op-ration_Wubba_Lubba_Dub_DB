package henrotaym.env.entities;

import henrotaym.env.enums.CharacterStatusName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "characters")
public class Character {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  private BigInteger apiCharacterId;

  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private CharacterStatusName status;

  private String image;
  private Integer episodeCount;
}
