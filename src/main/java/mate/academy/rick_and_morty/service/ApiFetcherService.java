package mate.academy.rick_and_morty.service;

import java.util.List;
import mate.academy.rick_and_morty.dto.ApiResponseDto;
import mate.academy.rick_and_morty.model.MovieCharacter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ApiFetcherService {
  private final HttpClient httpClient;
  private final MovieCharacterService service;

  public ApiFetcherService(HttpClient httpClient, MovieCharacterService movieCharacterService) {
    this.httpClient = httpClient;
    this.service = movieCharacterService;
  }

  @Scheduled(cron = "0/30 * * * * *")
  public void fetchMovieCharacterInfo() {
    // we can move first url to application.properties and use @Value annotation here
    // we can refactore this method with do-while loop
    ApiResponseDto responseDto =
        httpClient.get("https://rickandmortyapi.com/api/character", ApiResponseDto.class);
    List<MovieCharacter> characters = responseDto.getResults();
    System.out.println(characters);
    service.saveAll(characters);
    while (responseDto.getInfo().getNext() != null) {
      responseDto =
          httpClient.get(responseDto.getInfo().getNext(), ApiResponseDto.class);
      System.out.println(characters);
      service.saveAll(characters);
    }
  }
}
