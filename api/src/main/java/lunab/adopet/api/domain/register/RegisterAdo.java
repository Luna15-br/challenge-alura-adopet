package domain.register;


import domain.user.UserData;
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
    private String cpf;
    private String tel;
    @ManyToOne
    @JoinColumn (name = "email", referencedColumnName = "login", nullable = false, unique = true)
    private UserData user;
    @Embedded
    private Address address;
    private boolean active;


    public RegisterAdo(@Valid RegisterDTO data, UserData user) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.tel = data.tel();
        this.address = new Address(data.address());
        this.user = user;
        this.active = true;
    }
}
