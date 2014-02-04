package br.com.gabrielrubens.filme.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.VotoRepository;

@Controller
public class FilmeController {
	private final FilmeRepository filmeRepository;
	private final Result result;
	private VotoRepository votoRepository;
	
	@Inject
	public FilmeController(Result result, VotoRepository votoRepository, FilmeRepository filmeRepository) {
		this.result = result;
		this.votoRepository = votoRepository;
		this.filmeRepository = filmeRepository;
	}
	
	public  FilmeController() {
		this(null, null, null);
	}
	
	@Path(value={"/filme/inserirBaseDeTeste", "/x"})
	public void inserirBaseDeTeste() {
		votoRepository.removeAll();
		filmeRepository.removeAll();

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
