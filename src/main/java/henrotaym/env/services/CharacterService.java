package henrotaym.env.services;

import henrotaym.env.entities.Character;
import henrotaym.env.entities.OriginEntities.CharacterOrigin;
import henrotaym.env.entities.OriginEntities.CharacterResponsOrigin;
import henrotaym.env.http.resources.CharacterResource;
import henrotaym.env.mappers.ResourceMapper;
import henrotaym.env.repositories.CharacterRepository;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
public class CharacterService {
  private RestClient restClient;
  private CharacterRepository characterRepository;
  private ResourceMapper resourceMapper;

  public CharacterResponsOrigin index(BigInteger pageNumber) {
    return this.restClient
        .get()
        .uri("/character/?page=" + pageNumber)
        .retrieve()
        .body(new ParameterizedTypeReference<CharacterResponsOrigin>() {});
  }

  public CharacterOrigin show(BigInteger id) {
    return this.restClient
        .get()
        .uri("/character/" + id)
        .retrieve()
        .body(new ParameterizedTypeReference<CharacterOrigin>() {});
  }

  // public CharacterResource store(CharacterRequest request) {
  //   Character character = new Character();

  //   return this.storeOrUpdate(request, character);
  // }

  // public CharacterResource update(BigInteger id, CharacterRequest request) {
  //   Character character = this.findById(id);

  //   return this.storeOrUpdate(request, character);
  // }

  public void storeOrUpdate(CharacterResource request) {
    Character character = this.findByApiCharacterId(request.id());
    character = this.resourceMapper.getCharacterMapper().request(request, character);
    character = this.characterRepository.save(character);
  }

  public Character findByApiCharacterId(BigInteger apiCharacterId) {
    return this.characterRepository
        .findByApiCharacterId(apiCharacterId)
        .orElseGet(() -> new Character());
  }
}
