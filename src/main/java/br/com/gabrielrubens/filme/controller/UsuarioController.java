package br.com.gabrielrubens.filme.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.model.Usuario;
import br.com.gabrielrubens.filme.model.UsuarioSession;
import br.com.gabrielrubens.filme.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	private final Result result;
	private final UsuarioSession usuarioSession;
	private final UsuarioRepository usuarioRepository;

	@Inject
	public UsuarioController(Result result, UsuarioRepository usuarioRepository, UsuarioSession usuarioSession) {
		this.result = result;
		this.usuarioRepository = usuarioRepository;
		this.usuarioSession = usuarioSession;
	}

	public UsuarioController(){
		this(null, null, null);
	}
	
	@Path("/usuario/atualizar")
	public void atualizar(Usuario usuario) {
		Usuario usuarioAtualizar = usuarioSession.getUsuario();
		usuarioAtualizar.setNome(usuario.getNome());
		usuarioAtualizar.setEmail(usuario.getEmail());
		usuarioRepository.update(usuarioAtualizar);
		result.redirectTo(VotoController.class).ranking();
	}
}