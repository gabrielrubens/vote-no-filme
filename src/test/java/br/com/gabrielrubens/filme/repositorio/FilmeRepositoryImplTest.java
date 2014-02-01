package br.com.gabrielrubens.filme.repositorio;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabrielrubens.filme.helper.DBUnitHelper;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.FilmeRepositoryImpl;

public class FilmeRepositoryImplTest{
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		DBUnitHelper.beforeClass(Filme.class);
	}

	@Before
	public void before(){
		DBUnitHelper.before();
	}
	
	@AfterClass
	public static void afterClass(){
		DBUnitHelper.afterClass();
	}
	
	@Test
	public void deveRetornarOs5Filmes() {
		FilmeRepository filmeRepositoryImpl = new FilmeRepositoryImpl(DBUnitHelper.getEntityManager());
		Assert.assertEquals(5, filmeRepositoryImpl.findIds().size());
	}
	
	@Test
	public void deveRetornar2FilmesPorId() {
		FilmeRepository filmeRepositoryImpl = new FilmeRepositoryImpl(DBUnitHelper.getEntityManager());
		Assert.assertNotNull(filmeRepositoryImpl.find(1L));
		Assert.assertNotNull(filmeRepositoryImpl.find(2L));
	}
}
