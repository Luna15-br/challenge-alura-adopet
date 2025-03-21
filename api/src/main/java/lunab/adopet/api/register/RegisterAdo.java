package lunab.adopet.api.register;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lunab.adopet.api.address.Address;

@Table(name = "register")
@Entity
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RegisterAdo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String tel;
    @Embedded
    private Address address;
    private boolean active;


    public RegisterAdo(@Valid DataRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.tel = data.tel();
        this.address = new Address(data.address());
        this.active = true;
    }
}
