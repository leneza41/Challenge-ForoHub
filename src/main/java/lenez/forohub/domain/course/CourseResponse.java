package lenez.forohub.domain.course;

public record CourseResponse (
    Long id,
    String name
) {

    public CourseResponse(Course course) {
        this(course.getId(), course.getName());
    }
}
