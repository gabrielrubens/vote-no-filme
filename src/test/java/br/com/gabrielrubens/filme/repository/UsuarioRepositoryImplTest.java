package br.com.gabrielrubens.filme.repository;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabrielrubens.filme.helper.DBUnitHelper;
import br.com.gabrielrubens.filme.model.Usuario;

public class UsuarioRepositoryImplTest {
	private UsuarioRepository repository;
	private Usuario usuario;
	
	@Test
	public void deveInserir() {
		repository.insert(usuario);
	}

	@Test
	public void deveAtualizar() {
		repository.insert(usuario);
		usuario.setEmail("Novo Gabriel");
		repository.update(usuario);
	}

	@Test
	public void deveRemoverTodos() {
		repository.removeAll();
	}

	@BeforeClass
	public static void beforeClass() throws Exception{
		DBUnitHelper.beforeClass(Usuario.class);
	}

	@Before
	public void before(){
		DBUnitHelper.before();
		EntityManager entityManager = DBUnitHelper.getEntityManager();
		repository = new UsuarioRepositoryImpl(entityManager);
		usuario = new Usuario("Gabriel", "gabriel@gabriel.com.br");
	}
	
	@AfterClass
	public static void afterClass(){
		DBUnitHelper.afterClass();
	}
	
	@After
	public void after(){
		DBUnitHelper.after();
	}
}
