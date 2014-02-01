package br.com.gabrielrubens.filme.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.model.Disputa;

@Controller
public class VotoController {

	private final Result result;
	private final Disputa disputa;

	@Inject
	public VotoController(Result result, Disputa disputa) {
		this.result = result;
		this.disputa = disputa;
	}
	
	public VotoController() {
		this(null, null);
	}

	@Path(value={ "/", "vote-no-filme"})
	public void index() {
		if(disputa.temCandidatos()){
			result.include("candidatos", disputa.proximosCandidatos());
		}
	}
}