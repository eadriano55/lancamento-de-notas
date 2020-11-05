package br.provajavaweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8394521746019641350L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alunoId;
	
	@Column(name = "nomeAluno")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public Aluno() {
		
	}
	
	public Aluno(Integer alunoId, String nome, String matricula) {
		super();
		this.alunoId = alunoId;
		this.nome = nome;
	}

	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunoId == null) ? 0 : alunoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (alunoId == null) {
			if (other.alunoId != null)
				return false;
		} else if (!alunoId.equals(other.alunoId))
			return false;
		return true;
	}

}
