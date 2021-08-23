package mate.academy.rick_and_morty.dao;

import java.util.List;
import mate.academy.rick_and_morty.model.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
  // select * from MovieCharacter mc where mc.name like :namePart;
  List<MovieCharacter> findAllByNameContains(String namePart);
}
