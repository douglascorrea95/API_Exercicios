package org.serratec.backend.exercicioBanco.repository;

import org.serratec.backend.exercicioBanco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
