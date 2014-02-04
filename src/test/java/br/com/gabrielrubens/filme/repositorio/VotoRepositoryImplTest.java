package br.com.gabrielrubens.filme.repositorio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabrielrubens.filme.helper.DBUnitHelper;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Voto;
import br.com.gabrielrubens.filme.repository.VotoRepository;
import br.com.gabrielrubens.filme.repository.VotoRepositoryImpl;

public class VotoRepositoryImplTest{
	private VotoRepository repository;

	@BeforeClass
	public static void beforeClass() throws Exception{
		DBUnitHelper.beforeClass(Filme.class);
	}

	@Before
	public void before(){
		DBUnitHelper.before();
		repository = new VotoRepositoryImpl(DBUnitHelper.getEntityManager());
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
	public void deveVotar() {
		Filme filme1 = new Filme(1L, "Filme 1");
		Filme filme2 = new Filme(2L, "Filme 2");
		Candidatos candidatos = new Candidatos(filme1, filme2);
		Voto voto = new Voto(candidatos, filme1);
		
		
		repository.votar(voto);
	}
}