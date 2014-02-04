package br.com.gabrielrubens.filme.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.gabrielrubens.filme.repository.FilmeRepository;

public class DisputaTest {

	@Test
	public void deveTer10DisputasDos5Filmes() throws Exception {
		FilmeRepository filmeRepository = Mockito.mock(FilmeRepository.class);
		Mockito.when(filmeRepository.findIds()).thenReturn(Arrays.asList(1L,2L,3L,4L,5L));

		Disputa disputa = new Disputa(filmeRepository);
		disputa.init();
		Candidatos candidatos = null;
		
		for(int i = 0; i < 10; i++) {
			assertTrue(disputa.temCandidatos());
			candidatos = disputa.proximosCandidatos();
			assertNotNull(candidatos);
		}
		
		assertFalse(disputa.temCandidatos());
	}
}
