package lunab.adopet.api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, String> {

    UserData findByLogin(String login);
}
