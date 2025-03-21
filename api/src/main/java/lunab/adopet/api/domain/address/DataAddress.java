package lunab.adopet.api.domain.address;

import jakarta.validation.constraints.NotBlank;

public record DataAddress(
        @NotBlank
        String uf,
        @NotBlank
        String city
) {
}
