package lenez.forohub.domain.topic;

import lenez.forohub.domain.course.Course;
import lenez.forohub.domain.course.CourseRepository;
import lenez.forohub.domain.topic.validators.Validator;
import lenez.forohub.domain.user.User;
import lenez.forohub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    List<Validator> validators;

    public Topic register(TopicRequest data) {
        validators.forEach(validator -> validator.validate(data));
        Course course = courseRepository.findById(data.course()).get();
        User author = userRepository.findById(data.author()).get();
        return repository.save(new Topic(data.title(), data.message(), author, course));
    }
    public ResponseEntity<Topic> findById(Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<List<TopicResponse>> getTopics() {
        List<Topic> topics = repository.findAll();
        List<TopicResponse> responses = new ArrayList<>();
        topics.forEach(topic -> responses.add(new TopicResponse(topic)));
        return ResponseEntity.ok(responses);
    }
    public ResponseEntity<Topic> update(Long id, TopicRequest data) {
        validators.forEach(validator -> validator.validate(data));
        Course course = courseRepository.findById(data.course()).get();
        User author = userRepository.findById(data.author()).get();
        return repository.findById(id)
                .map(topic -> {
                    topic.setTitle(data.title());
                    topic.setMessage(data.message());
                    topic.setAuthor(author);
                    topic.setCourse(course);
                    return ResponseEntity.ok(repository.save(topic));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
