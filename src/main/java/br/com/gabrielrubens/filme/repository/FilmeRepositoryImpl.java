package br.com.gabrielrubens.filme.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gabrielrubens.filme.model.Filme;

public class FilmeRepositoryImpl extends Repository<Filme, Long> implements
		FilmeRepository, Serializable {

	@Inject
	public FilmeRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public FilmeRepositoryImpl() {
		this(null);
	}

	public List<Long> findIds() {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT f.id FROM Filme f", Long.class);
		List<Long> resultList = query.getResultList();
		return resultList;
	}
	
	public void insertAll(Collection<Filme> filmes) {
		for (Filme filme : filmes) {
			entityManager.persist(filme);
		}
	}

	public void removeAll() {
		entityManager.createQuery("delete from Filme").executeUpdate();
	}
}
