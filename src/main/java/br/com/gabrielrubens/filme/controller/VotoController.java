package br.com.gabrielrubens.filme.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Disputa;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Voto;
import br.com.gabrielrubens.filme.repository.VotoRepository;

@Controller
public class VotoController {

	private final Result result;
	private final Disputa disputa;
	private final VotoRepository repository;

	@Inject
	public VotoController(Result result, Disputa disputa, VotoRepository repository) {
		this.result = result;
		this.disputa = disputa;
		this.repository = repository;
	}
	
	public VotoController() {
		this(null, null, null);
	}

	@Path(value={ "/", "vote-no-filme"})
	public void index() {
		incluirProximoCandidato();
	}

	@Path("/voto/votar")
	public void votar(Candidatos candidatos, Filme filmeVotado) {
		repository.votar(new Voto(candidatos, filmeVotado));
		if(incluirProximoCandidato()){
			result.redirectTo(this).index();
		}
	}
	
	private boolean incluirProximoCandidato() {
		if(disputa.temCandidatos()){
			result.include("candidatos", disputa.proximosCandidatos());
			return true;
		}
		return false;
	}
}