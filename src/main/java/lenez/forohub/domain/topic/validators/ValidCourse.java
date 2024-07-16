package lenez.forohub.domain.topic.validators;

import lenez.forohub.domain.course.CourseRepository;
import lenez.forohub.domain.topic.TopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidCourse implements Validator {

    @Autowired
    private CourseRepository repository;

    @Override
    public void validate(TopicRequest data) {
        if(repository.findById(data.course()).isEmpty()) {
            throw new IllegalArgumentException("Course not found");
        }
    }
}
