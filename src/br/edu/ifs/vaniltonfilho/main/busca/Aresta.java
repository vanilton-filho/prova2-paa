package br.edu.ifs.vaniltonfilho.main.busca;

public class Aresta {
	private Vertice origem;
	private Vertice destino;
	private Pesos pesos;
	
	public Aresta(Vertice origem, Vertice destino, Pesos pesos) {
		this.origem = origem;
		this.destino = destino;
		this.pesos = pesos;
	}
	
	public Vertice getOrigem() {
		return origem;
	}
	
	public Vertice getDestino() {
		return destino;
	}
	
	public Pesos getPesos() {
		return pesos;
	}
	
	public void setPesos(Pesos pesos) {
		this.pesos = pesos;
	}
	
	@Override
	public String toString() {
		return origem + " " + destino;
	}
	
}
