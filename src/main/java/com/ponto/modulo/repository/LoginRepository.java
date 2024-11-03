package com.ponto.modulo.repository;

import com.ponto.modulo.model.LoginModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Id> {


}
