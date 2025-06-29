package henrotaym.env.services;

import henrotaym.env.entities.Character;
import henrotaym.env.entities.Episode;
import henrotaym.env.entities.OriginEntities.CharacterOrigin;
import henrotaym.env.entities.OriginEntities.EpisodeResponsOrigin;
import henrotaym.env.http.resources.EpisodeResource;
import henrotaym.env.mappers.ResourceMapper;
import henrotaym.env.repositories.CharacterRepository;
import henrotaym.env.repositories.EpisodeRepository;
import java.math.BigInteger;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
@Slf4j
public class EpisodeService {
  private RestClient restClient;
  private CharacterRepository characterRepository;
  private EpisodeRepository episodeRepository;
  private ResourceMapper resourceMapper;
  private CharacterService characterService;

  public EpisodeResponsOrigin index(BigInteger pageNumber) {
    return this.restClient
        .get()
        .uri("/episode/?page=" + pageNumber)
        .retrieve()
        .body(new ParameterizedTypeReference<EpisodeResponsOrigin>() {});
  }

  // public CharacterResource store(CharacterRequest request) {
  //   Character character = new Character();

  //   return this.storeOrUpdate(request, character);
  // }

  // public CharacterResource update(BigInteger id, CharacterRequest request) {
  //   Character character = this.findById(id);

  //   return this.storeOrUpdate(request, character);
  // }

  public void storeOrUpdate(EpisodeResource request) {
    // todo Penser à fair une relation many to many entre les episodes et les characters...

    Optional<Episode> existingEpisodeOpt = this.episodeRepository.findByApiEpisodeId(request.id());
    if (existingEpisodeOpt.isPresent()) {
      return;
    }
    Episode episode = new Episode();
    episode = this.resourceMapper.getEpisodeMapper().request(request, episode);
    episode = this.episodeRepository.save(episode);
    for (String characterUrl : episode.getCharacters()) {
      BigInteger characterId = extractCharacterIdFromUrl(characterUrl);
      if (characterId == null) continue;

      Optional<Character> optionalCharacter = this.characterRepository.findById(characterId);
      if (optionalCharacter.isEmpty()) continue;

      Character character = optionalCharacter.get();
      CharacterOrigin characterOrigin = this.characterService.show(characterId);
      Boolean find = false;
      for (String episodeInCharacter : characterOrigin.getEpisode()) {
        BigInteger id = extractEpisodeIdFromUrl(episodeInCharacter);
        if (id.equals(episode.getApiEpisodeId())) {
          find = true;
        }
      }
      if (find) {
        Integer episodeCount = character.getEpisodeCount();
        if (episodeCount == null) {
          episodeCount = 0;
        }

        character.setEpisodeCount(episodeCount + 1);
        // if (character.getName().equals("Arbolian Mentirososian")) {
        //   log.info(character.getEpisodeCount().toString());
        // }
        this.characterRepository.save(character);
      }
    }
  }

  public Episode findByApiEpisodeId(BigInteger apiEpisodeId) {
    return this.episodeRepository.findByApiEpisodeId(apiEpisodeId).orElseGet(() -> new Episode());
  }

  private BigInteger extractCharacterIdFromUrl(String url) {
    String[] parts = url.split("/");
    return new BigInteger(parts[parts.length - 1]);
  }

  private BigInteger extractEpisodeIdFromUrl(String url) {
    String[] parts = url.split("/");
    return new BigInteger(parts[parts.length - 1]);
  }
}
