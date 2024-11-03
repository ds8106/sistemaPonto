package com.ponto.modulo.controller;

import com.ponto.modulo.model.BoletaPontoModel;
import com.ponto.modulo.repository.BPModelRepository;
import com.ponto.modulo.service.BoletoPontoDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;



@CrossOrigin("*")
@RestController
@RequestMapping("/boletaPonto")
public class BoletaPontoController {

    private final BPModelRepository bpModelRepository;


    public BoletaPontoController(BPModelRepository bpModelRepository) {
        this.bpModelRepository = bpModelRepository;
    }

    @PostMapping("/registroEntrada")
    @ResponseStatus(HttpStatus.CREATED)
    public BoletaPontoModel registroEntrada(@RequestBody BoletaPontoModel boletaPontoModel) {
        BoletoPontoDataService boletoPontoDataService = new BoletoPontoDataService();
        boletaPontoModel.setRegistroEntrada(boletoPontoDataService.registroEntrada());
        System.out.println("Registro efetuado com sucesso!");
        return bpModelRepository.save(boletaPontoModel);

    }


    @PutMapping("/registroSaida/{id}")
    public BoletaPontoModel registroSaida(@PathVariable Long id) throws ParseException {
        BoletoPontoDataService boletoPontoDataService = new BoletoPontoDataService();
        BoletaPontoModel newBoletaPontoModel = bpModelRepository.findById(id);
        newBoletaPontoModel.setRegistroSaida(boletoPontoDataService.registroSaida());

        newBoletaPontoModel.setBancoDeHoras(boletoPontoDataService.bancoDeHoras(
                        newBoletaPontoModel.getRegistroEntrada(), newBoletaPontoModel.getRegistroSaida()));
        BoletaPontoModel updateBoletaPontoModel = bpModelRepository.save(newBoletaPontoModel);

        System.out.println("Registro efetuado com sucesso!");
        return updateBoletaPontoModel;


    }
        @GetMapping("/get")
        public ResponseEntity<List<BoletaPontoModel>> getCadastro() {
            System.out.println("Cadastro retornado com sucesso!");
            return ResponseEntity.ok(bpModelRepository.findAll());

        }
    }

