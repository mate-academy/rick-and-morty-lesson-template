package mate.academy.rick_and_morty.dto;

import java.util.List;
import lombok.Data;
import mate.academy.rick_and_morty.model.MovieCharacter;

@Data
public class ApiResponseDto {
  private ApiResponseInfo info;
  private List<MovieCharacter> results; // we should use list of dtos here
}
