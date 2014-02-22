package br.com.gabrielrubens.filme.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.gabrielrubens.filme.repository.FilmeRepository;

@SessionScoped
public class Disputa implements Serializable {
	private static final long serialVersionUID = -1088759555087603209L;
	private Combinacao combinacao;
	private final FilmeRepository filmeRepository;
	
	@Inject
	public Disputa(FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
	}
	
	public Disputa() {
		this(null);
	}
	
	@PostConstruct
	public void init() {
		List<Long> findIds = filmeRepository.findIds();
		Collections.shuffle(findIds);
		this.combinacao = new Combinacao(findIds, 2);
	}
	
	public boolean temCandidatos() {
		return combinacao.hasNext();
	}

	public Candidatos proximosCandidatos() {
		Long[] next = combinacao.next();
		Filme filme1 = filmeRepository.findById(next[0]);
		Filme filme2 = filmeRepository.findById(next[1]);
		return new Candidatos(filme1, filme2);
	}
}