package br.com.gabrielrubens.filme.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gabrielrubens.filme.model.Voto;

public class VotoRepositoryImpl extends Repository<Voto, Long> implements
		VotoRepository {

	@Inject
	public VotoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public VotoRepositoryImpl() {
		this(null);
	}

	@Override
	public void votar(Voto voto) {
		entityManager.persist(voto);
	}
}
