package br.com.gabrielrubens.filme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gabrielrubens.filme.model.Filme;

public class FilmeRepositoryImpl extends Repository<Filme, Long> implements
		FilmeRepository {

	public FilmeRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Long> findIds() {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT f.id FROM Filme f", Long.class);
		List<Long> resultList = query.getResultList();
		System.out.println("FilmeRepositoryImpl.findIds(): " + resultList.size());
		return resultList;
	}
	
	public Filme find(Long id) {
		return entityManager.find(Filme.class, id);
	}
}
