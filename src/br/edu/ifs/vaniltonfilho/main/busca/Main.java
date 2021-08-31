package br.edu.ifs.vaniltonfilho.main.busca;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
	   List<Vertice> vertices = new ArrayList<>();
       List<Aresta> arestas = new ArrayList<>();


       Vertice verticeA = new Vertice("A");
       Vertice verticeB = new Vertice("B");
       Vertice verticeC = new Vertice("C");
       Vertice verticeD = new Vertice("D");
       Vertice verticeE = new Vertice("E");
       Vertice verticeF = new Vertice("F");
       Vertice verticeG = new Vertice("G");
       

       vertices.add(verticeA);
       vertices.add(verticeB);
       vertices.add(verticeC);
       vertices.add(verticeD);
       vertices.add(verticeE);
       vertices.add(verticeF);
       vertices.add(verticeG);
       
       arestas.add(new Aresta(verticeA, verticeB, new Pesos(1, 2, 4)));
       arestas.add(new Aresta(verticeB, verticeA, new Pesos(1, 2, 4)));
       
       arestas.add(new Aresta(verticeB, verticeC, new Pesos(2, 2, 4)));
       arestas.add(new Aresta(verticeC, verticeB, new Pesos(2, 2, 4)));
       
       arestas.add(new Aresta(verticeA, verticeD, new Pesos(2, 2, 1)));
       arestas.add(new Aresta(verticeD, verticeA, new Pesos(2, 2, 1)));
       
       arestas.add(new Aresta(verticeD, verticeB, new Pesos(3, 3, 3)));
       arestas.add(new Aresta(verticeB, verticeD, new Pesos(3, 3, 3)));
       
       arestas.add(new Aresta(verticeB, verticeE, new Pesos(4, 2, 1)));
       arestas.add(new Aresta(verticeE, verticeB, new Pesos(4, 2, 1)));
       
       arestas.add(new Aresta(verticeD, verticeE, new Pesos(5, 5, 5)));
       arestas.add(new Aresta(verticeE, verticeD, new Pesos(5, 5, 5)));
       
       arestas.add(new Aresta(verticeD, verticeF, new Pesos(2, 2, 2)));
       arestas.add(new Aresta(verticeF, verticeD, new Pesos(2, 2, 2)));
       
       arestas.add(new Aresta(verticeF, verticeE, new Pesos(2, 2, 4)));
       arestas.add(new Aresta(verticeE, verticeF, new Pesos(2, 2, 4)));
       
       arestas.add(new Aresta(verticeE, verticeG, new Pesos(3, 3, 3)));
       arestas.add(new Aresta(verticeG, verticeE, new Pesos(3, 3, 3)));

       arestas.add(new Aresta(verticeF, verticeG, new Pesos(5, 5, 1)));
       arestas.add(new Aresta(verticeG, verticeF, new Pesos(5, 5, 1)));
       
       Grafo grafo = new Grafo(vertices, arestas);
       DijkstraMenorCaminho mapa = new DijkstraMenorCaminho(grafo);

       mapa.menorDistanciaEntre(verticeD, verticeE);
	}
}
