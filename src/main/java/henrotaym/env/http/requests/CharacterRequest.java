package henrotaym.env.http.requests;

import henrotaym.env.enums.CharacterStatusName;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;

public record CharacterRequest(
    @NotNull BigInteger id,
    @NotNull String name,
    @NotNull BigInteger apiCharacterId,
    @NotNull CharacterStatusName status,
    @NotNull String image,
    @NotNull Integer episodeCount) {}
