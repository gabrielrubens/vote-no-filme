package br.com.gabrielrubens.filme.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.gabrielrubens.filme.model.Ranking;
import br.com.gabrielrubens.filme.model.UsuarioSession;
import br.com.gabrielrubens.filme.repository.RankingRepository;

@Controller
public class RankingController {

	private final Result result;
	private final RankingRepository repository;
	private final UsuarioSession usuarioSession;

	@Inject
	public RankingController(Result result, RankingRepository repository, UsuarioSession usuarioSession) {
		this.result = result;
		this.repository = repository;
		this.usuarioSession = usuarioSession;
	}
	public RankingController(){
		this(null, null, null);
	}

	@Path("/ranking/index")
	public void index() {
		
	}
	
	@Path("/ranking/ranking")
	public void ranking() {
		
		List<List<Ranking>> listas = new ArrayList<>();
		listas.add(repository.rankingPorUsuario(usuarioSession.getUsuario()));
		listas.add(repository.rankingGeral());
		
		result.use(Results.representation())
				.from(listas)
				.recursive()
				.serialize();
	}
}
