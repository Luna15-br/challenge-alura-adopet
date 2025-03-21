package lunab.adopet.api.domain.register;


import lunab.adopet.api.domain.user.AuthData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lunab.adopet.api.domain.address.Address;
import lunab.adopet.api.domain.user.UserData;

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
    @JoinColumn (name = "user_login", referencedColumnName = "login", nullable = false, unique = true)
    private UserData user;
    @Embedded
    private Address address;
    private boolean active;


    public RegisterAdo(RegisterDTO data, AuthData user) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.tel = data.tel();
        this.address = new Address(data.address());
        this.user = new UserData(user);
        this.active = true;
    }
}
