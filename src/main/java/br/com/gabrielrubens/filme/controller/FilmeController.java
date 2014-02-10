package br.com.gabrielrubens.filme.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.UsuarioRepository;
import br.com.gabrielrubens.filme.repository.VotoRepository;

@Controller
public class FilmeController {
	private final Result result;
	private final FilmeRepository filmeRepository;
	private final VotoRepository votoRepository;
	private final UsuarioRepository usuarioRepository;
	
	@Inject
	public FilmeController(Result result, VotoRepository votoRepository, FilmeRepository filmeRepository, UsuarioRepository usuarioRepository) {
		this.result = result;
		this.votoRepository = votoRepository;
		this.filmeRepository = filmeRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public  FilmeController() {
		this(null, null, null, null);
	}
	
	@Path(value={"/filme/inserirBaseDeTeste", "/x"})
	public void inserirBaseDeTeste() {
		votoRepository.removeAll();
		filmeRepository.removeAll();
		usuarioRepository.removeAll();

		filmeRepository.insertAll(criarFilmesParaTeste());
		result.include("mensagem", "Filmes incluidos com sucesso!");
	}

	private List<Filme> criarFilmesParaTeste() {
		List<Filme> filmes = new ArrayList<>();
		for(int i=0; i<5; i++){
			filmes.add(new Filme("Nome " + i));
		}
		return filmes;
	}
}
