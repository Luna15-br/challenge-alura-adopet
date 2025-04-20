package lunab.adopet.api.domain.register;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterAdo, Long> {
  RegisterAdo findByUser_Login(String login);
}
