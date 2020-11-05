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
@Table(name="Modulo")
public class Modulo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer moduloId;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name ="curso_id")
	private Curso curso;
	
	public Modulo() {
		
	}
	
	public Modulo(Integer moduloId, String nome) {
		super();
		this.moduloId = moduloId;
		this.nome = nome;
	}
	public Integer getModuloId() {
		return moduloId;
	}
	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moduloId == null) ? 0 : moduloId.hashCode());
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
		Modulo other = (Modulo) obj;
		if (moduloId == null) {
			if (other.moduloId != null)
				return false;
		} else if (!moduloId.equals(other.moduloId))
			return false;
		return true;
	}

}
