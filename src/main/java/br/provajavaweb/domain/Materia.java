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
@Table(name="Materia")
public class Materia implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer materiaId;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name ="modulo_id")
	private Modulo modulo;
	
	public Materia() {
		
	}
	
	public Materia(Integer materiaId, String nome) {
		super();
		this.materiaId = materiaId;
		this.nome = nome;
	}
	public Integer getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(Integer materiaId) {
		this.materiaId = materiaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materiaId == null) ? 0 : materiaId.hashCode());
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
		Materia other = (Materia) obj;
		if (materiaId == null) {
			if (other.materiaId != null)
				return false;
		} else if (!materiaId.equals(other.materiaId))
			return false;
		return true;
	}

}
