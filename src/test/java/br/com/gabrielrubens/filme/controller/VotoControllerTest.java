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
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Voto;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.VotoRepository;

public class VotoControllerTest {
	private MockResult result;
	private VotoController controller;
	private Disputa disputa;
	@Mock private FilmeRepository filmeRepository;
	@Mock private VotoRepository votoRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		Mockito.when(filmeRepository.findIds()).thenReturn(Arrays.asList(1L,2L,3L,4L,5L));
		Mockito.when(filmeRepository.findById(Mockito.anyLong())).thenReturn(new Filme(""));
		disputa = new Disputa(filmeRepository);
		disputa.init();
		controller = new VotoController(result, disputa, votoRepository);
	}

	@Test
	public void deveApresentarOsCondidatos() {
		controller.index();
		verificaSeHaCandidatosNoResult();
	}

	@Test
	public void deveVotarEmUmFilme(){
		Filme filme1 = new Filme(1L, "Filme 1");
		Filme filme2 = new Filme(2L, "Filme 2");
		Candidatos candidatos = new Candidatos(filme1, filme2);
		
		controller.votar(candidatos, filme1);
		
		Mockito.verify(votoRepository).votar(Mockito.any(Voto.class));
		verificaSeHaCandidatosNoResult();
	}
	
	private void verificaSeHaCandidatosNoResult() {
		Candidatos candidatos = result.included("candidatos");
		assertNotNull(candidatos);
		assertNotNull(candidatos.getFilme1());
		assertNotNull(candidatos.getFilme2());
	}
}
