package br.com.gabrielrubens.filme.model;

import javax.inject.Inject;

import br.com.gabrielrubens.filme.repository.FilmeRepository;


public class Disputa {
	private final Combinacao combinacao;
	
	@Inject
	public Disputa(final FilmeRepository filmeRepository) {
		this.combinacao = new Combinacao(filmeRepository.findIds(), 2);
	}
	
	public Disputa() {
		this(null);
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