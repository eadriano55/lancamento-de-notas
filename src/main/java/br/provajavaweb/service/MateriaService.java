package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.provajavaweb.domain.Materia;
import br.provajavaweb.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository repository;

	public List<Materia> findAll() {
		return repository.findAll();
	}

	public Materia findById(Integer materiaId) {
		return repository.findById(materiaId).get();
	}

	public Materia materiaSalvar(Materia materia) {

		return repository.save(materia);
	}

	public void Excluir(Integer id) {

		repository.deleteById(id);
	}

	public Materia Editar(Materia materia) {
		Materia materiaAntiga = findById(materia.getMateriaId());
		materiaAntiga.setNome(materia.getNome());
		return materiaSalvar(materiaAntiga);
	}

}
