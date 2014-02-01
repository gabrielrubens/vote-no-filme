package br.com.gabrielrubens.filme.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Disputa;
import br.com.gabrielrubens.filme.model.Filme;

public class VotoControllerTest {
	private MockResult result;
	private VotoController controller;
	@Mock private Disputa disputa;
	private Candidatos candidatos;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new VotoController(result, disputa);
		candidatos = new Candidatos(new Filme(1L, "Filme 1"), new Filme(2L, "Filme 2"));
	}

	@Test
	public void deveApresentarOsCondidatos() {
		when(disputa.proximosCandidatos()).thenReturn(candidatos);
		
		when(disputa.temCandidatos()).thenReturn(true);
		
		controller.index();
		Candidatos candidatos = result.included("candidatos");
		assertNotNull(candidatos);
		assertNotNull(candidatos.getFilme1());
		assertNotNull(candidatos.getFilme2());
	}
}
