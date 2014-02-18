package br.com.gabrielrubens.filme.model;

public class Ranking {

	private final Filme filme;
	private final Long quantidadeDeVotos;

	public Ranking(Filme filme, Long quantidadeDeVotos) {
		this.filme = filme;
		this.quantidadeDeVotos = quantidadeDeVotos;
	}

	
	public String getNomeDoFilme() {
		return this.filme.getNome();
	}
	
	public Long getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}
	public String toString() {
		return "Ranking [filme=" + filme + ", quantidadeDeVotos="
				+ quantidadeDeVotos + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filme == null) ? 0 : filme.hashCode());
		result = prime
				* result
				+ ((quantidadeDeVotos == null) ? 0 : quantidadeDeVotos
						.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ranking other = (Ranking) obj;
		if (filme == null) {
			if (other.filme != null)
				return false;
		} else if (!filme.equals(other.filme))
			return false;
		if (quantidadeDeVotos == null) {
			if (other.quantidadeDeVotos != null)
				return false;
		} else if (!quantidadeDeVotos.equals(other.quantidadeDeVotos))
			return false;
		return true;
	}
}
