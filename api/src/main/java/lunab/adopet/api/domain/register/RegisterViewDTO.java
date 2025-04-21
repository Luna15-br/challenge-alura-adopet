package lunab.adopet.api.domain.register;

import lunab.adopet.api.domain.address.Address;

public record RegisterViewDTO(
        Long id,
        String name,
        String tel,
        String login,
        String username,
        String city,
        String uf
) {
    public RegisterViewDTO (RegisterAdo registerAdo) {
        this(registerAdo.getId(), registerAdo.getName(), registerAdo.getCpf(), registerAdo.getTel(), registerAdo.getUser().getUsername(), registerAdo.getAddress().getCity(), registerAdo.getAddress().getUf());
    }
}
