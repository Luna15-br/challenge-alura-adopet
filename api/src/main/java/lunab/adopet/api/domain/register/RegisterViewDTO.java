package lunab.adopet.api.domain.register;

import lunab.adopet.api.domain.address.Address;
import lunab.adopet.api.domain.user.UserData;

import java.util.Optional;

public record RegisterViewDTO(
        Long id,
        String nome,
        String telefone,
        String login,
        Address address
) {
    public RegisterViewDTO (RegisterAdo registerAdo) {
        this(registerAdo.getId(), registerAdo.getCpf(), registerAdo.getTel(), registerAdo.getUser().getUsername(), registerAdo.getAddress());
    }
}
