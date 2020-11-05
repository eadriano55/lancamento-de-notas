package br.provajavaweb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Turma")
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer turmaId;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name ="curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "modulo_id")
	private Modulo modulo;
	
	public Turma() {
		
	}
	
	public Turma(Integer turmaId, String nome) {
		super();
		this.turmaId = turmaId;
		this.nome = nome;
	}
	public Integer getTurmaId() {
		return turmaId;
	}
	public void setTurmaId(Integer turmaId) {
		this.turmaId = turmaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((turmaId == null) ? 0 : turmaId.hashCode());
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
		Turma other = (Turma) obj;
		if (turmaId == null) {
			if (other.turmaId != null)
				return false;
		} else if (!turmaId.equals(other.turmaId))
			return false;
		return true;
	}

}
