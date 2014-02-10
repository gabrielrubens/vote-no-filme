package br.com.gabrielrubens.filme.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.gabrielrubens.filme.repository.UsuarioRepository;

@SessionScoped
public class UsuarioSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private final UsuarioRepository usuarioRepository;
	private Usuario usuario;
	
	@Inject
	public UsuarioSession(UsuarioRepository UsuarioRepository) {
		this.usuarioRepository = UsuarioRepository;
	}

	public UsuarioSession(){
		this(null);
	}
	
	@PostConstruct
	public void init() throws Exception {
		this.usuario = new Usuario();
		usuarioRepository.insert(usuario);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
