package br.edu.ifs.vaniltonfilho.main.busca;

import java.util.List;

public class Grafo {
	private List<Vertice> verticeList;
    private List<Aresta> arestaList;

    public Grafo(List<Vertice> verticeList, List<Aresta> arestaList) {
        this.verticeList = verticeList;
        this.arestaList = arestaList;
    }

    public List<Vertice> getVerticeList() {
        return verticeList;
    }

    public List<Aresta> getArestaList() {
        return arestaList;
    }
}
