package br.com.gabrielrubens.filme.repository;

import java.util.List;

import br.com.gabrielrubens.filme.model.Ranking;
import br.com.gabrielrubens.filme.model.Usuario;

public interface RankingRepository {
	List<Ranking> rankingGeral();
	List<Ranking> rankingPorUsuario(Usuario usuario);
}
