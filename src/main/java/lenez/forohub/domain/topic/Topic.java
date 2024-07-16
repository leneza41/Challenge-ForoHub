package lenez.forohub.domain.topic;

import jakarta.persistence.*;
import lenez.forohub.domain.course.Course;
import lenez.forohub.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Topic(String title, String message, User author, Course course) {
        this.title = title;
        this.message = message;
        this.createdDate = LocalDateTime.now();
        this.status = Status.OPEN;
        this.author = author;
        this.course = course;
    }
}
