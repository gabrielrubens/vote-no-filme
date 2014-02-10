package br.com.gabrielrubens.filme.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gabrielrubens.filme.model.Usuario;

public class UsuarioRepositoryImpl extends Repository<Usuario, Long> implements
		UsuarioRepository {
	private static final long serialVersionUID = 1L;

	@Inject
	public UsuarioRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public void insert(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public void update(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public void removeAll() {
		entityManager.createQuery("delete from Usuario").executeUpdate();
	}

}
