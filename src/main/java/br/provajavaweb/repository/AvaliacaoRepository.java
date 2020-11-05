package br.provajavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.provajavaweb.domain.Avaliacao;
import br.provajavaweb.domain.EmbeddableAvaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, EmbeddableAvaliacao>{

}
