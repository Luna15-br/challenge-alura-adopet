package lunab.adopet.api.controller;

import lunab.adopet.api.domain.register.RegisterRepository;
import lunab.adopet.api.domain.register.RegisterViewDTO;
import lunab.adopet.api.domain.user.UserData;
import lunab.adopet.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegisterRepository registerRepository;


    @GetMapping("/me")
    public ResponseEntity<RegisterViewDTO> getProfile(@AuthenticationPrincipal UserData user) {
        System.out.println("Usuário autenticado: " + user.getUsername());
        var register = registerRepository.findByUser_Login(user.getUsername());
        var dto = new RegisterViewDTO(register);
        return ResponseEntity.ok(dto);
    }




}
