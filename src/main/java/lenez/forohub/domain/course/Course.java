package lenez.forohub.domain.course;

import jakarta.persistence.*;
import lenez.forohub.domain.topic.Topic;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "courses")
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "topic_id")
    private List<Topic> topics;
}
