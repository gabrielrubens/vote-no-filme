package br.com.gabrielrubens.filme.controller;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Disputa;
import br.com.gabrielrubens.filme.repository.FilmeRepository;

public class VotoControllerTest {
	private MockResult result;
	private VotoController controller;
	private Disputa disputa;
	@Mock private FilmeRepository filmeRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		Mockito.when(filmeRepository.findIds()).thenReturn(Arrays.asList(1L,2L,3L,4L,5L));
		disputa = new Disputa(filmeRepository);
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
