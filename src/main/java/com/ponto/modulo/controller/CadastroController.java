package com.ponto.modulo.controller;

import com.ponto.modulo.model.CadastroModel;
import com.ponto.modulo.repository.CadModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    private final CadModelRepository repository;


    public CadastroController(CadModelRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroModel addCadastro(@RequestBody CadastroModel cadastroModel){
        System.out.println("Cadastro de novo funcionário efetuado com sucesso!");
        return repository.save(cadastroModel);

    }

    @GetMapping("/get")
    public ResponseEntity <List<CadastroModel>> getCadastro(){
        System.out.println("Cadastro retornado com sucesso!");
        return ResponseEntity.ok(repository.findAll());

    }
}
