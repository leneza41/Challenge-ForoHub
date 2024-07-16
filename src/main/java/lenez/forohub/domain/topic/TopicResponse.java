package lenez.forohub.domain.topic;

import lenez.forohub.domain.course.Course;
import lenez.forohub.domain.course.CourseResponse;
import lenez.forohub.domain.user.User;
import lenez.forohub.domain.user.UserResponse;

import java.time.LocalDateTime;

public record TopicResponse (
        String title,
        String message,
        LocalDateTime createdDate,
        Status status,
        UserResponse author,
        CourseResponse course
) {
    public TopicResponse(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreatedDate(),
                topic.getStatus(), new UserResponse(topic.getAuthor()),
                new CourseResponse(topic.getCourse()));
    }
}
