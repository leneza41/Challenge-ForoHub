package lenez.forohub.domain.topic;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Override
    Optional<Topic> findById(Long aLong);
    Boolean existsByTitleIgnoreCaseAndMessageIgnoreCase(String title, String message);

    @Override
    List<Topic> findAll();
}
