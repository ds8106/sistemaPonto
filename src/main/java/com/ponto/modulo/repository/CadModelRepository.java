package com.ponto.modulo.repository;

import com.ponto.modulo.model.CadastroModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Repository
public interface CadModelRepository extends JpaRepository<CadastroModel, Id> {


    ResponseEntity<CadastroModel> findById(CadastroModel id);
}
