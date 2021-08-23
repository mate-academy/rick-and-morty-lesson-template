package mate.academy.rick_and_morty.service;

import java.util.List;
import mate.academy.rick_and_morty.dao.MovieCharacterRepository;
import mate.academy.rick_and_morty.model.MovieCharacter;
import org.springframework.stereotype.Service;

@Service
public class MovieCharacterServiceImpl implements MovieCharacterService {
  private final MovieCharacterRepository repository;

  public MovieCharacterServiceImpl(MovieCharacterRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<MovieCharacter> findByNameContains(String namePart) {
    return repository.findAllByNameContains(namePart);
  }

  @Override
  public MovieCharacter getRandom() {
    long count = repository.count();
    long randomId = (long) (Math.random() * count);
    // we can get exception here, because we use external id and it can not exist
    return repository.findById(randomId).get();
  }

  @Override
  public void save(MovieCharacter movieCharacter) {
    repository.save(movieCharacter);
  }

  @Override
  public void saveAll(List<MovieCharacter> movieCharacters) {
    repository.saveAll(movieCharacters);
  }
}
