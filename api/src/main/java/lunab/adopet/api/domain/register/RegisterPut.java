package lunab.adopet.api.domain.register;

import lunab.adopet.api.domain.address.DataAddress;

public record RegisterPut(
        String name,
        String tel,
        DataAddress address,
        String descricao) {
}
