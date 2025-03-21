package lunab.adopet.api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthData(

        @NotBlank
        @Email
        String login,
        @NotBlank
        String password) {

}
