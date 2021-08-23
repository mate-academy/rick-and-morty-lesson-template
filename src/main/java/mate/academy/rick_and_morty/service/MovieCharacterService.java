package mate.academy.rick_and_morty.service;

import java.util.List;
import mate.academy.rick_and_morty.model.MovieCharacter;

public interface MovieCharacterService {
  List<MovieCharacter> findByNameContains(String namePart);

  MovieCharacter getRandom();

  void save(MovieCharacter movieCharacter);

  void saveAll(List<MovieCharacter> movieCharacters);
}
