package mate.academy.rick_and_morty.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MovieCharacter {
  @Id
  private Long id;
  private String gender;
  private String image;
  private String name;
  private String status;
  private String url;
}
