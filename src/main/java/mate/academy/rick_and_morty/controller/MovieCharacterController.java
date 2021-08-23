package mate.academy.rick_and_morty.controller;

import java.util.List;
import mate.academy.rick_and_morty.model.MovieCharacter;
import mate.academy.rick_and_morty.service.MovieCharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class MovieCharacterController {
  private final MovieCharacterService service;

  public MovieCharacterController(MovieCharacterService service) {
    this.service = service;
  }

  @GetMapping("/random")
  public MovieCharacter getRandom() {
    // we should use here mapper and dto
    return service.getRandom();
  }

  @GetMapping("/by-name")
  public List<MovieCharacter> characterByNameContains(@RequestParam String namePart) {
    // we should use here mapper and dto
    return service.findByNameContains(namePart);
  }
}
