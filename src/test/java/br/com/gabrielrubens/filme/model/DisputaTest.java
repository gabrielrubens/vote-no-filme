package br.com.gabrielrubens.filme.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisputaTest {

	@Test
	public void test() {
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
