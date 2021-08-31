package br.edu.ifs.vaniltonfilho.main.arvore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class Vertice {

	private String titulo;
	private Map<Vertice, Aresta> arestas = new HashMap<>();
	private boolean isVisitado = false;

	public Vertice(String label) {
		this.titulo = label;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String label) {
		this.titulo = label;
	}

	public Map<Vertice, Aresta> getArestas() {
		return arestas;
	}

	public void adicionarAresta(Vertice vertex, Aresta edge) {
		if (this.arestas.containsKey(vertex)) {
			if (edge.getPeso() < this.arestas.get(vertex).getPeso()) {
				this.arestas.replace(vertex, edge);
			}
		} else {
			this.arestas.put(vertex, edge);
		}
	}

	public boolean isVisitado() {
		return isVisitado;
	}

	public void setVisitado(boolean visitado) {
		isVisitado = visitado;
	}

	public Pair<Vertice, Aresta> proximoMin() {
		Aresta proximoMin = new Aresta(Integer.MAX_VALUE);
		Vertice proximoVertice = this;
		Iterator<Map.Entry<Vertice, Aresta>> it = arestas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Vertice, Aresta> par = it.next();
			if (!par.getKey().isVisitado()) {
				if (!par.getValue().isIncluso()) {
					if (par.getValue().getPeso() < proximoMin.getPeso()) {
						proximoMin = par.getValue();
						
						proximoVertice = par.getKey();
					}
				}
			}
		}
		return new Pair<>(proximoVertice, proximoMin);
	}

	public String grafoOriginal() {
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<Vertice, Aresta>> it = arestas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Vertice, Aresta> par = it.next();
			if (!par.getValue().isImpresso()) {
				sb.append(getTitulo());
				sb.append(" --- peso = ");
				sb.append(par.getValue().getPeso());
				sb.append(" --- ");
				sb.append(par.getKey().getTitulo());
				sb.append("\n");
				par.getValue().setImpresso(true);
			}
		}
		return sb.toString();
	}

	public String arvoreGerada() {
		StringBuilder sb = new StringBuilder();
		if (isVisitado()) {
			Iterator<Map.Entry<Vertice, Aresta>> it = arestas.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Vertice, Aresta> par = it.next();
				if (par.getValue().isIncluso()) {
					if (!par.getValue().isImpresso()) {
						sb.append(getTitulo());
						sb.append(" --- peso = ");
						sb.append(par.getValue().getPeso());
						sb.append(" --- ");
						sb.append(par.getKey().getTitulo());
						sb.append("\n");
						par.getValue().setImpresso(true);
					}
				}
			}
		}
		return sb.toString();
	}

}
