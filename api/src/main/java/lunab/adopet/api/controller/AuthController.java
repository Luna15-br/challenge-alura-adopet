package lunab.adopet.api.controller;


import jakarta.validation.Valid;
import lunab.adopet.api.domain.register.RegisterRepository;
import lunab.adopet.api.domain.user.AuthData;
import lunab.adopet.api.domain.user.UserData;
import lunab.adopet.api.infra.security.TokenJWTData;
import lunab.adopet.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping
    public ResponseEntity<?> signIn(@RequestBody @Valid AuthData auth) {
        try {
            var token = new UsernamePasswordAuthenticationToken(auth.login(), auth.password());
            var authentication = manager.authenticate(token);
            var userData = (UserData) authentication.getPrincipal();
            var register = registerRepository.findByUser_Login(userData.getUsername());
            if (!register.isActive()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            var jwt = tokenService.gerarToken(userData);
            return ResponseEntity.ok(new TokenJWTData(jwt));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
