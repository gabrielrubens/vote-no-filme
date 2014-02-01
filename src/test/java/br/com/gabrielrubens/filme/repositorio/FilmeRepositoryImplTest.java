package br.com.gabrielrubens.filme.repositorio;

import org.junit.AfterClass;
import static org.junit.Assert.*;
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
		filmeRepositoryImpl = new FilmeRepositoryImpl(DBUnitHelper.getEntityManager());
	}
	
	@AfterClass
	public static void afterClass(){
		DBUnitHelper.afterClass();
	}
	
	@Test
	public void deveRetornarOs5Filmes() {
		assertEquals(5, filmeRepositoryImpl.findIds().size());
	}
	
	@Test
	public void deveRetornar2FilmesPorId() {
		assertNotNull(filmeRepositoryImpl.find(1L));
		assertNotNull(filmeRepositoryImpl.find(2L));
	}
}
