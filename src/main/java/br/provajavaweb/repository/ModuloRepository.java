package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer>{

}
