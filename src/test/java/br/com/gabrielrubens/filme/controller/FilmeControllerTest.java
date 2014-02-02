package br.com.gabrielrubens.filme.controller;

import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.FilmeRepositoryImpl;

public class FilmeControllerTest {

	@Test
	public void deveCriar5Filmes() {
		FilmeRepository filmeRepository = Mockito.mock(FilmeRepositoryImpl.class);
		MockResult result = new MockResult();
		FilmeController controller = new FilmeController(result, filmeRepository);
		controller.inserirBaseDeTeste();
		
		verify(filmeRepository).removeAll();
		verify(filmeRepository).insertAll(anyCollectionOf(Filme.class));
		Assert.assertEquals("Filmes incluidos com sucesso!", result.included("mensagem"));
	}
}