package br.com.gabrielrubens.filme.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockSerializationResult;
import br.com.gabrielrubens.filme.helper.MockResultHelper;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Ranking;
import br.com.gabrielrubens.filme.model.Usuario;
import br.com.gabrielrubens.filme.model.UsuarioSession;
import br.com.gabrielrubens.filme.repository.RankingRepository;

import com.thoughtworks.xstream.XStream;

public class RankingControllerTest {

	private List<Ranking> rankingPorUsuario;
	private List<Ranking> rankingGeral;
	
	@Before
	public void setUp(){
		rankingPorUsuario = getRankingPorUsuario();
		rankingGeral = getRankingGeral();
	}

	@Test
	public void deveConterORankingPorUsuarioEGeral() throws Exception {
		MockSerializationResult result = MockResultHelper.criarMockResult();
		RankingRepository repository = Mockito.mock(RankingRepository.class);
		UsuarioSession usuarioSession = Mockito.mock(UsuarioSession.class);
		
		Mockito.when(repository.rankingPorUsuario(Mockito.any(Usuario.class))).thenReturn(rankingPorUsuario);
		Mockito.when(repository.rankingGeral()).thenReturn(rankingGeral);
		
		RankingController controller = new RankingController(result, repository, usuarioSession);

		controller.ranking();
		
		String recebido = result.serializedResult();
		System.out.println(recebido);
		XStream stream = new XStream();
		stream.alias("ranking", Ranking.class);
		
		@SuppressWarnings("unchecked")
		List<List<Ranking>> list = (List<List<Ranking>>) stream.fromXML(recebido);
		
		//TODO: este teste esta muito acoplado com a implementecao, issue #11
		Assert.assertEquals(getRankingPorUsuario(), list.get(0));
		Assert.assertEquals(getRankingGeral(), list.get(1));
	}
	
	private List<Ranking> getRankingPorUsuario() {
		List<Ranking> list = new ArrayList<>();
		Ranking ranking = null;
		for (int i = 1; i <= 5; i++) {
			ranking = new Ranking(new Filme(Long.valueOf(i), "Filme "+i), Long.valueOf(i));
			list.add(ranking);
		}
		return list;
	}

	private List<Ranking> getRankingGeral() {
		List<Ranking> list = new ArrayList<>();
		Ranking ranking = null;
		for (int i = 5; i <= 10; i++) {
			ranking = new Ranking(new Filme(Long.valueOf(i), "Filme "+i), Long.valueOf(i));
			list.add(ranking);
		}
		return list;
	}
}
