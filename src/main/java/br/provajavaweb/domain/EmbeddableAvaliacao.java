package br.provajavaweb.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class EmbeddableAvaliacao implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@ManyToOne
	private Materia materia;
	
	
	@ManyToOne
	private Aluno aluno;


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
