package henrotaym.env.http.resources;

import java.math.BigInteger;
import java.util.List;

public record EpisodeResource(
    BigInteger id,
    BigInteger apiEpisodeId,
    String name,
    String episodeCode,
    List<String> characters) {}
