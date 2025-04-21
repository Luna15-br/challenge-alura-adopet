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
    @JoinColumn(name = "user_login", referencedColumnName = "login", nullable = false, unique = true)
    private UserData user;
    @Embedded
    private Address address;
    private boolean active;

    public RegisterAdo () {

    }

    public RegisterAdo(RegisterDTO data, AuthData user) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.tel = data.tel();
        this.address = new Address(data.address());
        this.user = new UserData(user);
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
