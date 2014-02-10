package br.com.gabrielrubens.filme.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.gabrielrubens.filme.repository.UsuarioRepository;
import br.com.gabrielrubens.filme.repository.UsuarioRepositoryImpl;

public class UsuarioSessionTest {
	private UsuarioSession usuarioSession;
	
	@Test
	public void deveRetornaroUsuarioDaSession() throws Exception {
		UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepositoryImpl.class);
		new UsuarioSession();
		usuarioSession = new UsuarioSession(usuarioRepository);
		usuarioSession.init();
		assertNotNull(usuarioSession.getUsuario());
	}

}
