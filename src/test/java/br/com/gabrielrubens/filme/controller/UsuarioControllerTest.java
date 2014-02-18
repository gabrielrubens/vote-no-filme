package br.com.gabrielrubens.filme.controller;

import org.junit.Test;
import static org.mockito.Mockito.*;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.gabrielrubens.filme.model.Usuario;
import br.com.gabrielrubens.filme.model.UsuarioSession;
import br.com.gabrielrubens.filme.repository.UsuarioRepository;

public class UsuarioControllerTest {

	@Test
	public void deveAtualizarUmUsuario() throws Exception {
		MockResult result = spy(new MockResult());
		UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
		UsuarioSession usuarioSession = mock(UsuarioSession.class);
		Usuario usuario = new Usuario("Gabriel", "gabriel@gabriel.com.br");
		UsuarioController controller = new UsuarioController(result, usuarioRepository, usuarioSession);
		RankingController rankingController = mock(RankingController.class);

		when(usuarioSession.getUsuario()).thenReturn(usuario);
		when(result.redirectTo(RankingController.class)).thenReturn(rankingController);
		
		controller.atualizar(usuario);
		
		verify(rankingController, only()).index();
	}
}
