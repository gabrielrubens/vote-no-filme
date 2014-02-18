package br.com.gabrielrubens.filme.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Ranking;
import br.com.gabrielrubens.filme.model.Usuario;

//TODO: aprender mais sobre criteria, esse codigo esta feio (issue #10)
public class RankingRepositoryImpl extends Repository<Usuario, Long> implements
		RankingRepository {
	private static final int ID_DO_FILME = 0;
	private static final int NOME_DO_FILME = 1;
	private static final int QTD_DE_VOTOS = 2;
	private static final long serialVersionUID = 1L;

	@Inject
	public RankingRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Ranking> rankingGeral() {
		
		StringBuilder qry = new StringBuilder()
			.append("SELECT v.filmeEscolhido.id AS id, ")
			.append("v.filmeEscolhido.nome AS nome, ")
			.append("COUNT(v.filmeEscolhido) AS total ")
			.append("FROM Voto AS v ")
			.append("GROUP BY v.filmeEscolhido.id, v.filmeEscolhido.nome ")
			.append("ORDER BY total DESC");

		List<Object[]> resultList = entityManager.createQuery(qry.toString())
				.getResultList();
		
		List<Ranking> rankings = preencherListas(resultList);
		rankings.addAll(getFilmesSemVoto());
		return rankings;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ranking> rankingPorUsuario(Usuario usuario) {
		StringBuilder qry = new StringBuilder()
		.append("SELECT v.filmeEscolhido.id AS id, ")
		.append("v.filmeEscolhido.nome AS nome, ")
		.append("COUNT(v.filmeEscolhido) AS total ")
		.append("FROM Voto AS v ")
		.append("WHERE v.usuario = :usuario ")
		.append("GROUP BY v.filmeEscolhido.id, v.filmeEscolhido.nome ")
		.append("ORDER BY total DESC");
		
		Query createQuery = entityManager.createQuery(qry.toString());

		createQuery.setParameter("usuario", usuario);

		List<Object[]> resultList = createQuery.getResultList();

		List<Ranking> rankings = preencherListas(resultList);
		rankings.addAll(getFilmesSemVoto(usuario));
		return rankings;
	}

	private List<Ranking> preencherListas(List<Object[]> resultList) {
		List<Ranking> rankings = new ArrayList<>();
		Ranking ranking;
		Filme filme;
		for (Object[] objects : resultList) {
			filme = new Filme((Long) objects[ID_DO_FILME], String.valueOf(objects[NOME_DO_FILME]));
			ranking = new Ranking(filme, (Long) objects[QTD_DE_VOTOS]);

			rankings.add(ranking);
		}
		return rankings;
	}
	
	private List<Ranking> getFilmesSemVoto(){
		List<Ranking> rankings = new ArrayList<>();
		
		List<Filme> filmesSemVotos = entityManager.createQuery("from Filme as filme where filme not in (select filmeEscolhido from Voto)", Filme.class)
		.getResultList();
		
		for (Filme filme : filmesSemVotos) {
			rankings.add(new Ranking(filme, 0L));
		}
		
		return rankings;
	}
	
	private List<Ranking> getFilmesSemVoto(Usuario usuario){
		List<Ranking> rankings = new ArrayList<>();
		
		StringBuilder qry = new StringBuilder()
				.append("from Filme as filme ")
				.append("where filme ")
				.append("not in (select filmeEscolhido from Voto as voto where voto.usuario = :usuario)");
				;
		List<Filme> filmesSemVotos = entityManager
											.createQuery(qry.toString(), Filme.class)
											.setParameter("usuario", usuario)
											.getResultList();
		
		
		for (Filme filme : filmesSemVotos) {
			rankings.add(new Ranking(filme, 0L));
		}
		
		return rankings;
	}
	
}