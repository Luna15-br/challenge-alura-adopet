package domain.user;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "user-data")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    private String login;
    private String password;


    public UserData(AuthData authData) {
        this.login = authData.login();
        this.password = authData.password();
    }
}
