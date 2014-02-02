package br.com.gabrielrubens.filme.repository;

import java.util.Collection;
import java.util.List;

import br.com.gabrielrubens.filme.model.Filme;

public interface FilmeRepository {
	Filme findById(Long id);
	List<Long> findIds();
	void insertAll(Collection<Filme> filmes);
	void removeAll();
}
