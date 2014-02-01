package br.com.gabrielrubens.filme.model;

import java.util.Iterator;

public class Disputa {
	private Iterator<Long[]> combinacao;

	public Disputa(Iterator<Long[]> combinacao) {
		this.combinacao = combinacao;
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