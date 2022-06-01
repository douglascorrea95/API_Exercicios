package org.serratec.backend.exerciciobiblioteca.repository;

import org.serratec.backend.exerciciobiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Livro, Integer>{

}
