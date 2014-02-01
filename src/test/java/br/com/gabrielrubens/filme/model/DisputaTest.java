package br.com.gabrielrubens.filme.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DisputaTest {

	@Test
	public void deveTer10DisputasDos5Filmes() {
		Disputa disputa = new Disputa(new Combinacao(Arrays.asList(1L, 2L, 3L, 4L, 5L), 2));
		Candidatos candidatos = null;
		
		for(int i = 0; i < 10; i++) {
			assertTrue(disputa.temCandidatos());
			candidatos = disputa.proximosCandidatos();
			assertNotNull(candidatos);
		}
		
		assertFalse(disputa.temCandidatos());
	}
}
