package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{

}
