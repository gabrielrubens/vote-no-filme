package br.com.gabrielrubens.filme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {
	@Id @GeneratedValue
	private Long id;
	private String nome;
	
	@SuppressWarnings("unused")
	private Filme() {}
	
	public Filme(Long Id, String nome) {
		this.id = Id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + "]";
	}
}
