package br.com.gabrielrubens.filme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voto {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private final Filme filme1;
	@ManyToOne
	private final Filme filme2;
	@ManyToOne
	private final Filme filmeEscolhido;
	
	public Voto(Candidatos candidatos, Filme filmeVotado) {
		this.filme1 = candidatos.getFilme1();
		this.filme2 = candidatos.getFilme2();
		this.filmeEscolhido = filmeVotado;
	}

	public Long getId() {
		return id;
	}

	public Filme getFilme1() {
		return filme1;
	}

	public Filme getFilme2() {
		return filme2;
	}

	public Filme getFilmeEscolhido() {
		return filmeEscolhido;
	}
}
