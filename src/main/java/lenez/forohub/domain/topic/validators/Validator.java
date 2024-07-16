package lenez.forohub.domain.topic.validators;

import lenez.forohub.domain.topic.TopicRequest;

public interface Validator {
    public void validate(TopicRequest data);
}
