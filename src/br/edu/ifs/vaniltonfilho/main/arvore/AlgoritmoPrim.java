package br.edu.ifs.vaniltonfilho.main.arvore;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class AlgoritmoPrim {

	private List<Vertice> grafo;
	
	public AlgoritmoPrim(List<Vertice> grafo) {
		this.grafo = grafo;
	}

	public void executar() {
		if (grafo.size() > 0) {
			grafo.get(0).setVisitado(true);
		}
		while (isDisconectado()) {
			Aresta proximoMin = new Aresta(Integer.MAX_VALUE);
			Vertice proximoVertice = grafo.get(0);
			for (Vertice vertice : grafo) {
				if (vertice.isVisitado()) {
					Pair<Vertice, Aresta> candidato = vertice.proximoMin();
					if (candidato.getValue().getPeso() < proximoMin.getPeso()) {
						proximoMin = candidato.getValue();
						proximoVertice = candidato.getKey();
					}
				}
			}
			proximoMin.setIncluso(true);
			proximoVertice.setVisitado(true);
		}
	}

	private boolean isDisconectado() {
		for (Vertice vertice : grafo) {
			if (!vertice.isVisitado()) {
				return true;
			}
		}
		return false;
	}

	public String grafoOriginal() {
		StringBuilder sb = new StringBuilder();
		for (Vertice vertice : grafo) {
			sb.append(vertice.grafoOriginal());
		}
		return sb.toString();
	}

	public void resetPrint() {
		for (Vertice vertice : grafo) {
			Iterator<Map.Entry<Vertice, Aresta>> it = vertice.getArestas().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Vertice, Aresta> par = it.next();
				par.getValue().setImpresso(false);
			}
		}
	}

	public String arvoreGeradoraMinima() {
		StringBuilder sb = new StringBuilder();
		for (Vertice vertice : grafo) {
			sb.append(vertice.arvoreGerada());
		}
		return sb.toString();
	}
}
