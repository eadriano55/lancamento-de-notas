package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Aluno;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
