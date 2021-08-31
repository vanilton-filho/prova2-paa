package br.edu.ifs.vaniltonfilho.main.busca;

public class Vertice {
	
	private String titulo;
	
	public Vertice(String label) {
		this.titulo = label;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setLabel(String label) {
		this.titulo = label;
	}
	
	@Override
	public String toString() {
		return titulo;
	}
}
