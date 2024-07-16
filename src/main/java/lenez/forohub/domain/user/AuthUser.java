package lenez.forohub.domain.user;

import jakarta.validation.constraints.NotNull;

public record AuthUser(
        @NotNull String email,
        @NotNull String password
) {
}
