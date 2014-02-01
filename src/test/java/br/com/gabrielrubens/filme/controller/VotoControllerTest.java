package br.com.gabrielrubens.filme.controller;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Combinacao;
import br.com.gabrielrubens.filme.model.Disputa;

public class VotoControllerTest {
	private MockResult result;
	private VotoController controller;
	private Disputa disputa;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		disputa = new Disputa(new Combinacao(Arrays.asList(1L, 2L, 3L, 4L, 5L), 2));
		controller = new VotoController(result, disputa);
	}

	@Test
	public void deveApresentarOsCondidatos() {
		controller.index();
		Candidatos candidatos = result.included("candidatos");
		assertNotNull(candidatos);
		assertNotNull(candidatos.getFilme1());
		assertNotNull(candidatos.getFilme2());
	}
}
