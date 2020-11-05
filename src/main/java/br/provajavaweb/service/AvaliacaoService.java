package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.provajavaweb.domain.Avaliacao;
import br.provajavaweb.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;
	
	public Avaliacao save(Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}
	
	public List<Avaliacao> findAll(){
		return repository.findAll();
	}
	
}
