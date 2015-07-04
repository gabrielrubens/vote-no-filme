package br.com.gabrielrubens.filme.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.service.FilmeService;

public class FilmeControllerTest {

	@Test
	public void deveCriar5Filmes() {
		FilmeService filmeService = Mockito.mock(FilmeService.class);
		MockResult result = new MockResult();
		FilmeController service = new FilmeController(result, filmeService);
		service.inserirBaseDeTeste();
		Assert.assertEquals("Filmes incluidos com sucesso!", result.included("mensagem"));
	}
}
