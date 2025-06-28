package henrotaym.env.http.controllers;

import henrotaym.env.services.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CharacterController {
  private CharacterService characterService;

  //   @GetMapping("")
  //   public ResponseEntity<List<CharacterResource>> index() {
  //     List<CharacterResource> games = this.characterService.index();

  //     return ResponseEntity.ok(games);
  //   }
}
