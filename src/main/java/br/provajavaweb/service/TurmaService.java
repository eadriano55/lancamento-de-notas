package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.provajavaweb.domain.Turma;
import br.provajavaweb.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

	public List<Turma> findAll() {
		return repository.findAll();
	}

	public Turma findById(Integer turmaId) {
		return repository.findById(turmaId).get();
	}

	public Turma turmaSalvar(Turma turma) {
		return repository.save(turma);
	}

	public void excluirTurma(Integer id) {
		repository.deleteById(id);
	}

	public Turma editarTurma(Turma turma) {
		Turma turmaAntiga = findById(turma.getTurmaId());
		turmaAntiga.setNome(turma.getNome());
		return turmaSalvar(turmaAntiga);
	}
}
