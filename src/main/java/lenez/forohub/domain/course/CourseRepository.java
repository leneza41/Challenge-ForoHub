package lenez.forohub.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Optional<Course> findById(Long id);
}
