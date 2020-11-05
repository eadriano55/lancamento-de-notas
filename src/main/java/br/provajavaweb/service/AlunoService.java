package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.provajavaweb.domain.Aluno;
import br.provajavaweb.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer alunoId){
		return repository.findById(alunoId).get();
	}
	
	public Aluno alunoSalvar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public void excluirAluno(Integer id) {
		repository.deleteById(id);
	}
	
	public Aluno editarAluno(Aluno aluno) {
		Aluno alunoAntigo = findById(aluno.getAlunoId());
		alunoAntigo.setNome(aluno.getNome());
		return alunoSalvar(alunoAntigo);
	}
}
