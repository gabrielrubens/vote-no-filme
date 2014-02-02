package br.com.gabrielrubens.filme.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabrielrubens.filme.helper.DBUnitHelper;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.FilmeRepositoryImpl;

public class FilmeRepositoryImplTest{
	
	private FilmeRepository filmeRepositoryImpl;

	@BeforeClass
	public static void beforeClass() throws Exception{
		DBUnitHelper.beforeClass(Filme.class);
	}

	@Before
	public void before(){
		DBUnitHelper.before();
		EntityManager entityManager = DBUnitHelper.getEntityManager();
		filmeRepositoryImpl = new FilmeRepositoryImpl(entityManager);
	}
	
	@AfterClass
	public static void afterClass(){
		DBUnitHelper.afterClass();
	}
	
	@After
	public void after(){
		DBUnitHelper.after();
	}
	
	@Test
	public void deveRetornarOs5Filmes() {
		assertEquals(5, filmeRepositoryImpl.findIds().size());
	}
	
	@Test
	public void deveRetornar2FilmesPorId() {
		assertNotNull(filmeRepositoryImpl.findById(1L));
		assertNotNull(filmeRepositoryImpl.findById(2L));
	}
	
	@Test
	public void deveInserirUmFilme(){
		List<Filme> filmes = new ArrayList<>();
		
		for(int i=0; i<5; i++){
			filmes.add(new Filme("Nome " + i));
		}
		filmeRepositoryImpl.removeAll();
		filmeRepositoryImpl.insertAll(filmes);
	}
}
