package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.provajavaweb.domain.Curso;
import br.provajavaweb.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(Integer cursoId){
		return repository.findById(cursoId).get();
	}
	
	public Curso cursoSalvar(Curso curso) {
		return repository.save(curso);
	}
	
	public void Excluir(Integer id) {
		repository.deleteById(id);
	}
	
	public Curso Editar(Curso curso) {
		Curso cursoAntigo = findById(curso.getCursoId());
		cursoAntigo.setNome(curso.getNome());
		return cursoSalvar(cursoAntigo);
	}
}
