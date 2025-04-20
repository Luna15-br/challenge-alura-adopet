package lunab.adopet.api.controller;


import jakarta.validation.Valid;
import lunab.adopet.api.domain.user.AuthData;
import lunab.adopet.api.domain.user.UserData;
import lunab.adopet.api.infra.security.TokenJWTData;
import lunab.adopet.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/login")
public class AuthManager {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity singin(@RequestBody @Valid AuthData auth) {
        var token = new UsernamePasswordAuthenticationToken(auth.login(), auth.password());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((UserData) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTData(tokenJWT));
    }
}
