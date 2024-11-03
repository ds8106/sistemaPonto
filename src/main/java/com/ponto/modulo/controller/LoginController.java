package com.ponto.modulo.controller;

import com.ponto.modulo.model.LoginModel;
import com.ponto.modulo.repository.LoginRepository;
import com.ponto.modulo.service.LoginEncription;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginRepository loginRepository;
    private final LoginEncription loginEncription;

    public LoginController(LoginRepository loginRepository, LoginEncription loginEncription) {
        this.loginRepository = loginRepository;
        this.loginEncription = loginEncription;
    }

    @PostMapping("/username")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginModel cadastraUsername(@RequestBody LoginModel username) {


        return loginRepository.save(username);

    }

    @PostMapping("/password")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginModel cadastraPassword(@RequestBody LoginModel password, LoginEncription loginEncription ) throws NoSuchAlgorithmException {
        password.setPassword(loginEncription.executeEncription(password.getPassword()));
        return loginRepository.save(password);
    }


    @GetMapping(path = "/login")
    public List<LoginModel> validaUsername() {
        return loginRepository.findAll();

    }


}
