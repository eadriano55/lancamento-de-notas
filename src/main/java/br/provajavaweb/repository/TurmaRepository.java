package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
