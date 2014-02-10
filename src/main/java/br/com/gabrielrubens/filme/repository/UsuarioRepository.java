package br.com.gabrielrubens.filme.repository;

import br.com.gabrielrubens.filme.model.Usuario;


public interface UsuarioRepository {
	void insert(Usuario usuario);
	void update(Usuario usuario);
	void removeAll();
}
