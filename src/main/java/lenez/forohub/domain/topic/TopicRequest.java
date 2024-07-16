package lenez.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;
import lenez.forohub.domain.user.User;

public record TopicRequest (
        @NotNull String title,
        @NotNull String message,
        @NotNull Long author,
        @NotNull Long course
) {
}
