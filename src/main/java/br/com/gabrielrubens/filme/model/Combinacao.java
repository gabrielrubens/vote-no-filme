package br.com.gabrielrubens.filme.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Classe que especifica o esquema de combinacao usando a contagem binaria.
 * 
 * @author Daemonio (Marcos Paulo Ferreira) Homepage:
 *         http://daemoniolabs.wordpress.com Mon Jul 4 14:44:14 BRT 2011
 * 
 * @author Gabriel Rubens - 29/01/14 Classe foi adaptada, link original:
 *         http://daemoniolabs
 *         .wordpress.com/2011/07/04/gerando-combinacoes-usando-java/
 * 
 */

public class Combinacao implements Iterator<Long[]>, Serializable{
	private int qtdDeCombinacoes;
	private List<Long> entrada;
	private int MAX;
	private int N;

	/**
	 * se qtdDeCombinacoes e' zero entao iremos fazer todas as combinacoes (com qualquer
	 * quantidade de elementos).
	 */
	public Combinacao(List<Long> entrada, int qtdDeCombinacoes) {
		this.qtdDeCombinacoes = qtdDeCombinacoes;
		this.entrada = entrada;
		this.MAX = ~(1 << entrada.size());
		this.N = 1;
	}

	public Combinacao() {
	}
	
	/**
	 * Retorna true quando ha pelo menos uma combinacao disponivel.
	 */
	public boolean hasNext() {
		if (qtdDeCombinacoes != 0) {
			while (((this.N & this.MAX) != 0) && (quantidadeDeBitsAtivos() != qtdDeCombinacoes))
				N += 1;
		}

		return (this.N & this.MAX) != 0;
	}

	/**
	 * Retorna a quantidade de bits ativos (= 1) de N.
	 */
	private int quantidadeDeBitsAtivos() {
		int i;
		int c;

		i = 1;
		c = 0;
		while ((this.MAX & i) != 0) {
			if ((this.N & i) != 0) {
				c++;
			}
			i = i << 1;
		}

		return c;
	}

	/**
	 * Util para obter o tamanho da saida. Esse tamanho e' o numero de posicoes
	 * do vetor retornado por next.
	 */
	private int getSaidaLength() {
		if (qtdDeCombinacoes != 0) {
			return qtdDeCombinacoes;
		}

		return this.quantidadeDeBitsAtivos();
	}

	/**
	 * Retorna uma combinacao.
	 * 
	 * ATENCAO: Sempre use next() quando se tem certeza que ha uma combinacao
	 * disponivel. Ou seja, sempre use next() quando hasNext() retornar true.
	 */
	public Long[] next() {
		int saida_index, entrada_index, i;

		Long[] saida = new Long[this.getSaidaLength()];

		entrada_index = 0;
		saida_index = 0;
		i = 1;

		while ((this.MAX & i) != 0) {
			if ((this.N & i) != 0) {
				saida[saida_index] = entrada.get(entrada_index);
				saida_index += 1;
			}
			entrada_index += 1;
			i = i << 1;
		}

		N += 1;

		return saida;
	}

	public void remove() {
		throw new RuntimeException(
				"Operação não permitida! O erro nao foi seu, foi de quem implementou esse metodo");
	}
}