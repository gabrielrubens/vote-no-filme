package br.com.gabrielrubens.filme.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gabrielrubens.filme.helper.DBUnitHelper;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Ranking;
import br.com.gabrielrubens.filme.model.Usuario;
import br.com.gabrielrubens.filme.model.Voto;

public class RankingRepositoryImplTest {

	private RankingRepository repository;
	private Repository<Usuario, Long> usuarioRepository;
	private Filme filme1;
	private Filme filme2;
	private Filme filme3;
	private Filme filme4;
	private Filme filme5;

	@BeforeClass
	public static void beforeClass() throws Exception{
		DBUnitHelper.beforeClass(Usuario.class, Filme.class,  Voto.class);
	}

	@Before
	public void before(){
		DBUnitHelper.before();
		EntityManager entityManager = DBUnitHelper.getEntityManager();
		repository = new RankingRepositoryImpl(entityManager);
		usuarioRepository = new UsuarioRepositoryImpl(entityManager);
		
		filme1 = new Filme(1l, "Primeiro Filme");
		filme2 = new Filme(2l, "Segundo Filme");
		filme3 = new Filme(3l, "Terceiro Filme");
		filme4 = new Filme(4l, "Quarto Filme");
		filme5 = new Filme(5l, "Quinto Filme");
	}
	
	@Test
	public void testRankingGeral() {
		List<Ranking> esperado = getRankingGeral();
		List<Ranking> recebido = repository.rankingGeral();
		
		Assert.assertEquals(esperado, recebido);
	}

	@Test
	public void testRankingPorUsuario() {
		List<Ranking> esperado = getRankingPorUsuario();
		Usuario usuario = usuarioRepository.findById(1L);
		List<Ranking> recebido = repository.rankingPorUsuario(usuario);

		Assert.assertEquals(esperado, recebido);
	}
	
	private List<Ranking> getRankingGeral() {
		return Arrays.asList(
				new Ranking(filme1, 8L),
				new Ranking(filme3, 4L),
				new Ranking(filme4, 4L),
				new Ranking(filme5, 3L),
				new Ranking(filme2, 1L)
			);
	}

	private List<Ranking> getRankingPorUsuario() {
		return Arrays.asList(
				new Ranking(filme1, 4L),
				new Ranking(filme3, 2L),
				new Ranking(filme4, 2L),
				new Ranking(filme5, 2L),
				new Ranking(filme2, 0L)
			);
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
