package lunab.adopet.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lunab.adopet.api.domain.register.RegisterPut;
import lunab.adopet.api.domain.register.RegisterRepository;
import lunab.adopet.api.domain.register.RegisterViewDTO;
import lunab.adopet.api.domain.user.UserData;
import lunab.adopet.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/account/me")
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegisterRepository registerRepository;


    @GetMapping
    public ResponseEntity<RegisterViewDTO> getProfile(@AuthenticationPrincipal UserData user) {
        System.out.println("Usuário autenticado: " + user.getUsername());
        var register = registerRepository.findByUser_Login(user.getUsername());
        var dto = new RegisterViewDTO(register);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<?> putProfile(@RequestBody @Valid RegisterPut put) {
        var authenticatedUser = (UserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var register = registerRepository.findByUser_Login(authenticatedUser.getUsername());
        register.atualizarInfo(put);
        return ResponseEntity.ok(new RegisterViewDTO(register));
    }




}
