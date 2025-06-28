package henrotaym.env.http.resources;

import henrotaym.env.enums.CharacterStatusName;
import java.math.BigInteger;

public record CharacterResource(
    BigInteger id,
    BigInteger apiCharacterId,
    String name,
    CharacterStatusName status,
    String image,
    Integer episodeCount) {}
