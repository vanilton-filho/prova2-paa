package br.edu.ifs.vaniltonfilho.main.arvore;

public class Aresta {

	private int peso;
	private boolean isIncluso = false;
	private boolean isImpresso = false;

	public Aresta(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isIncluso() {
		return isIncluso;
	}

	public void setIncluso(boolean valor) {
		isIncluso = valor;
	}

	public boolean isImpresso() {
		return isImpresso;
	}

	public void setImpresso(boolean impresso) {
		isImpresso = impresso;
	}

}
