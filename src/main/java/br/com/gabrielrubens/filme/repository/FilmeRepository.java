package br.com.gabrielrubens.filme.repository;

import java.util.List;

import br.com.gabrielrubens.filme.model.Filme;

public interface FilmeRepository {
	Filme find(Long id);

	List<Long> findIds();
}
