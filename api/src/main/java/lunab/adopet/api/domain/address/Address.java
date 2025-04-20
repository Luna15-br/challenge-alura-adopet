package lunab.adopet.api.domain.address;


import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Embeddable
public class Address {

    private String uf;
    private String city;

    public Address () {

    }

    public Address(@NotNull @Valid DataAddress address) {
        this.uf = address.uf();
        this.city = address.city();
    }
}

