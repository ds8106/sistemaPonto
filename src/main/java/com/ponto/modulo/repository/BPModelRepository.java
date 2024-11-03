package com.ponto.modulo.repository;

import com.ponto.modulo.model.BoletaPontoModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BPModelRepository extends JpaRepository<BoletaPontoModel, Id> {


    BoletaPontoModel findById(Long id);
}
