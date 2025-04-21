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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void atualizarEndereco(DataAddress address) {
        if(address.city() != null) {
            this.city = address.city();
        }
        if(address.uf() != null) {
            this.city = address.uf();
        }
    }
}

