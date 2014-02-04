package br.com.gabrielrubens.filme.model;

public class Candidatos {
	private Filme filme1;
	private Filme filme2;

	public Candidatos(Filme filme1, Filme filme2) {
		this.filme1 = filme1;
		this.filme2 = filme2;
	}

	public Filme getFilme1() {
		return filme1;
	}

	public void setFilme1(Filme filme1) {
		this.filme1 = filme1;
	}
	
	public Filme getFilme2() {
		return filme2;
	}

	public void setFilme2(Filme filme2) {
		this.filme2 = filme2;
	}
	
	public String toString() {
		return "Candidatos [filme1=" + filme1 + ", filme2=" + filme2 + "]";
	}
}
