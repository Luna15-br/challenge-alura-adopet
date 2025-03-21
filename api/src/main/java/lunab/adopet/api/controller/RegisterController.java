package lunab.adopet.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lunab.adopet.api.register.DataRegister;
import lunab.adopet.api.register.RegisterAdo;
import lunab.adopet.api.register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/create-account")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;


    @PostMapping
    @Transactional
    public ResponseEntity register (@RequestBody @Valid DataRegister data) {
        String email = data.email().toLowerCase(Locale.ROOT);

        var user = new RegisterAdo(data);
        user.setEmail(email);
        registerRepository.save(user);
        return ResponseEntity.ok().build();
    }







}
