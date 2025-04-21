package lunab.adopet.api.controller;


import lunab.adopet.api.domain.RegisterRequest;
import lunab.adopet.api.domain.register.RegisterDTO;
import lunab.adopet.api.domain.user.AuthData;
import lunab.adopet.api.domain.user.UserData;
import lunab.adopet.api.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lunab.adopet.api.domain.register.RegisterAdo;
import lunab.adopet.api.domain.register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest) {

        RegisterDTO data = registerRequest.registerDTO();
        AuthData authData = registerRequest.authData();
        String email = authData.login().toLowerCase(Locale.ROOT);
        var userLogin = new UserData(authData);
        userLogin.setLogin(email);
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        userRepository.save(userLogin);
        var userRegister = new RegisterAdo(data, authData);
        registerRepository.save(userRegister);
        return ResponseEntity.ok().build();
    }







}
