package br.provajavaweb.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmbeddableAvaliacao alunoMateria;
	
	private String conceito;
	
	public EmbeddableAvaliacao getAlunoMateria() {
		return alunoMateria;
	}

	public void setAlunoMateria(EmbeddableAvaliacao alunoMateria) {
		this.alunoMateria = alunoMateria;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	
}
