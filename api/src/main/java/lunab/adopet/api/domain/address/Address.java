package lunab.adopet.api.domain.address;


import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String uf;
    private String city;


    public Address(@NotNull @Valid DataAddress address) {
        this.uf = address.uf();
        this.city = address.city();
    }
}

