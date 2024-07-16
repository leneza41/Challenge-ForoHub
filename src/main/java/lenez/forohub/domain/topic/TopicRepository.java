package lenez.forohub.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Override
    Optional<Topic> findById(Long id);
    boolean existsById(Long id);
    Boolean existsByTitleIgnoreCaseAndMessageIgnoreCase(String title, String message);

    @Override
    List<Topic> findAll();
}
