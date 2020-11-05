package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
