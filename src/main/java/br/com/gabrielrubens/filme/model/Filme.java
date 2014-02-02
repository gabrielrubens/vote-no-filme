package br.com.gabrielrubens.filme.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	
	@SuppressWarnings("unused")
	private Filme() {}
	
	public Filme(Long Id, String nome) {
		this.id = Id;
		this.nome = nome;
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + "]";
	}
}
