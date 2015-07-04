package br.com.gabrielrubens.filme.service;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.UsuarioRepository;
import br.com.gabrielrubens.filme.repository.VotoRepository;

public class FilmeService {

	private VotoRepository votoRepository;
	private FilmeRepository filmeRepository;
	private UsuarioRepository usuarioRepository;

	public FilmeService(VotoRepository votoRepository, FilmeRepository filmeRepository, UsuarioRepository usuarioRepository) {
		this.votoRepository = votoRepository;
		this.filmeRepository = filmeRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public void inserirBaseDeTeste() {
		votoRepository.removeAll();
		filmeRepository.removeAll();
		usuarioRepository.removeAll();

		filmeRepository.insertAll(criarFilmesParaTeste());
	}
	
	private List<Filme> criarFilmesParaTeste() {
		List<Filme> filmes = new ArrayList<>();
		
		filmes.add(new Filme("Forrest Gump"));
		filmes.add(new Filme("Piratas do Vale do Silicio"));
		filmes.add(new Filme("A Procura da Felicidade"));
		filmes.add(new Filme("O Auto da Compadecida"));
		filmes.add(new Filme("Hitch - Conselheiro Amoroso"));
		
		return filmes;
	}
}
