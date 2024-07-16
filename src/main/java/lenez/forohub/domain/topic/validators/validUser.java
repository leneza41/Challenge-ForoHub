package lenez.forohub.domain.topic.validators;

import lenez.forohub.domain.topic.TopicRequest;
import lenez.forohub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class validUser implements Validator {
    @Autowired
    private UserRepository repository;

    @Override
    public void validate(TopicRequest data) {
        if(repository.findById(data.author()).isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
