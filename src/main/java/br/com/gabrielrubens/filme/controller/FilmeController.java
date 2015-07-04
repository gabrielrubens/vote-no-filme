package br.com.gabrielrubens.filme.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.service.FilmeService;

@Controller
public class FilmeController {
	private final Result result;
	private final FilmeService filmeService;
	
	@Inject
	public FilmeController(Result result, FilmeService filmeService) {
		this.result = result;
		this.filmeService = filmeService;
	}
	
	/** only to the CDI */
	@Deprecated
	public  FilmeController() {
		this(null, null);
	}
	
	@Path(value={"/filme/inserirBaseDeTeste", "/x"})
	public void inserirBaseDeTeste() {

		filmeService.inserirBaseDeTeste();
		result.include("mensagem", "Filmes incluidos com sucesso!");
		
		result.redirectTo(VotoController.class).index();
	}
}