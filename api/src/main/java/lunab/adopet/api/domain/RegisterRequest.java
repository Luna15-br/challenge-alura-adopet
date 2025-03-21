package lunab.adopet.api.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lunab.adopet.api.domain.register.RegisterDTO;
import lunab.adopet.api.domain.user.AuthData;

public record RegisterRequest(
         @Valid RegisterDTO registerDTO,
         @Valid AuthData authData
        ) {
}
