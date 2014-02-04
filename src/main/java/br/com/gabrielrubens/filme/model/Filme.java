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
	
	public Filme(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + "]";
	}
}
