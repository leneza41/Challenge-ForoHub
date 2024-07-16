package lenez.forohub.domain.topic.validators;

import lenez.forohub.domain.topic.TopicRequest;
import lenez.forohub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Duplicate implements Validator {
    @Autowired
    private TopicRepository repository;

    @Override
    public void validate(TopicRequest data) {
        if(repository.existsByTitleIgnoreCaseAndMessageIgnoreCase(data.title(), data.message())) {
            throw new IllegalArgumentException("Duplicate topic");
        }
    }
}
