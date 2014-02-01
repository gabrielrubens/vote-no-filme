package br.com.gabrielrubens.filme.model;

import java.util.Arrays;


public class Disputa {
	private final Combinacao combinacao;

	
	public Disputa() {
		this.combinacao = new Combinacao(Arrays.asList(1L, 2L, 3L, 4L, 5L), 2);
	}
	

	public boolean temCandidatos() {
		return combinacao.hasNext();
	}

	public Candidatos proximosCandidatos() {
		Long[] next = combinacao.next();
		return new Candidatos(
				new Filme(next[0],"Filme1"),
				new Filme(next[1],"Filme2"));
	}
}