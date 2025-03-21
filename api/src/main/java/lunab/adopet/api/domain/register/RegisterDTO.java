package domain.register;

import domain.user.AuthData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lunab.adopet.api.address.DataAddress;

public record RegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        String tel,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,
        @NotNull @Valid DataAddress address) {
}
