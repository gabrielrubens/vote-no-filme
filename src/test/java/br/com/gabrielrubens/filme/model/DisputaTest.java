package br.com.gabrielrubens.filme.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DisputaTest {

	@Test
	public void deveTer10DisputasDos5Filmes() {
		Disputa disputa = new Disputa();
		Candidatos candidatos = null;
		
		for(int i = 0; i < 10; i++) {
			assertTrue(disputa.temCandidatos());
			candidatos = disputa.proximosCandidatos();
			assertNotNull(candidatos);
		}
		
		assertFalse(disputa.temCandidatos());
	}
}
