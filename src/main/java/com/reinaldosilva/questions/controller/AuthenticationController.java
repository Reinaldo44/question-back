package com.reinaldosilva.questions.controller;

import com.reinaldosilva.questions.entity.Admin.LoginAdminDto;
import com.reinaldosilva.questions.entity.Admin.ResponseAdminDto;
import com.reinaldosilva.questions.entity.Admin.UserAdmin;
import com.reinaldosilva.questions.entity.Admin.RegisterDTO;
import com.reinaldosilva.questions.infra.security.TokenService;
import com.reinaldosilva.questions.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AdminRepository repository;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginAdminDto data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserAdmin) auth.getPrincipal());

        return ResponseEntity.ok(new ResponseAdminDto(token));

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserAdmin newUser = new UserAdmin(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
