package br.com.gabrielrubens.filme.model;

public class Filme {
	private Long id;
	private String nome;
	
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
