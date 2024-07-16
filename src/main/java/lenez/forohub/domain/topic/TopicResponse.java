package lenez.forohub.domain.topic;

import lenez.forohub.domain.course.Course;
import lenez.forohub.domain.user.User;

import java.time.LocalDateTime;

public record TopicResponse (
        String title,
        String message,
        LocalDateTime createdDate,
        Status status,
        User author,
        Course course
) {
    public TopicResponse(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreatedDate(),
                topic.getStatus(), topic.getAuthor(), topic.getCourse());
    }
}
