package br.edu.ifs.vaniltonfilho.main.busca;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;


public class DijkstraMenorCaminho {
	private List<Vertice> vertices;
    private List<Aresta> arestas;
    private Set<Vertice> verticesVisitados;
    private Set<Vertice> verticesNaoVisitados;
    private Map<Vertice, Vertice> antecessores;
    private Map<Vertice, Double> distancia;


    public DijkstraMenorCaminho(Grafo grafo) {
        this.vertices = new ArrayList<>(grafo.getVerticeList());
        this.arestas = new ArrayList<>(grafo.getArestaList());
    }

    private void executar(Vertice origem) {
        verticesVisitados = new HashSet<>();
        verticesNaoVisitados = new HashSet<>();
        distancia = new HashMap<>();
        antecessores = new HashMap<>();
        distancia.put(origem, Double.valueOf(0));
        verticesNaoVisitados.add(origem);
        while (verticesNaoVisitados.size() > 0) {
            Vertice vertice = getMin(verticesNaoVisitados);
            verticesVisitados.add(vertice);
            verticesNaoVisitados.remove(vertice);
            encontrarDistanciasMinimas(vertice);
        }
    }

    private void encontrarDistanciasMinimas(Vertice vertice) {
        List<Vertice> adjacentVertices = getVizinhos(vertice);
        for (Vertice target: adjacentVertices) {
            if (getMenorDistancia(target) > getMenorDistancia(vertice)
                    + getDistancia(vertice, target)
            ) {
                distancia.put(target, getMenorDistancia(vertice)
                + getDistancia(vertice, target));
                antecessores.put(target, vertice);
                verticesNaoVisitados.add(target);
            }
        }
    }

    private Double getDistancia(Vertice origem, Vertice destino) {
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(origem)
                && aresta.getDestino().equals(destino)) {

                return aresta.getPesos().soma();
            }
        }
        throw new RuntimeException("erro getDistancia");
    }

    private List<Vertice> getVizinhos(Vertice vertice) {
        List<Vertice> vizinhos = new ArrayList<>();
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(vertice)
                && !isVisitado(aresta.getDestino())) {
                vizinhos.add(aresta.getDestino());
            }
        }
        return vizinhos;
    }

    private Vertice getMin(Set<Vertice> vertices) {
        Vertice min = null;
        for (Vertice vertice : vertices) {
            if (min == null) {
                min = vertice;
            } else {
                if (getMenorDistancia(vertice) < getMenorDistancia(min)) {
                    min = vertice;
                }
            }
        }
        return min;
    }

    private boolean isVisitado(Vertice vertice) {
        return verticesVisitados.contains(vertice);
    }

    private Double getMenorDistancia(Vertice destino) {
        Double distancia = this.distancia.get(destino);
        if (distancia == null) {
            return Double.MAX_VALUE;
        } else {
            return distancia;
        }
    }

    public LinkedList<Vertice> getCaminho(Vertice origem, Vertice destino) {
        if (origem.getTitulo().equals(destino.getTitulo())) {
            LinkedList<Vertice> mesmoVertice = new LinkedList<Vertice>();
            mesmoVertice.add(new Vertice(origem.getTitulo()));
            return mesmoVertice;
        }
        executar(origem);
        LinkedList<Vertice> caminho = new LinkedList<>();
        Vertice passo = destino;

        if (antecessores.get(passo) == null) {
            return null;
        }
        caminho.add(passo);
        while (antecessores.get(passo) != null) {
            passo = antecessores.get(passo);
            caminho.add(passo);
        }

        Collections.reverse(caminho);
        return caminho;
    }

    public Double getPesos(LinkedList<Vertice> path) {
        Double peso = Double.valueOf(0);
        for (int i = 0; i < path.size() - 1; i++) {
            for (Aresta aresta: arestas) {
                if (aresta.getOrigem().equals(path.get(i))
                        && aresta.getDestino().equals(path.get(i + 1))) {
                    peso += new BigDecimal(aresta.getPesos().soma()).setScale(2, RoundingMode.HALF_DOWN).doubleValue();

                }
            }
        }
        return peso;
    }


    public String getCaminhoPeso(Vertice origem, Vertice destino) {
        LinkedList<Vertice> caminho = getCaminho(origem, destino);

        if (caminho == null) {
            return String.format("não existe caminho de %s para %s", origem, destino);
        }


        Double peso = getPesos(caminho);
        StringBuilder caminhoComPeso = new StringBuilder();
        caminhoComPeso.append("Menor caminho entre ");
        caminhoComPeso.append(origem.getTitulo());
        caminhoComPeso.append(" e ");
        caminhoComPeso.append(destino.getTitulo());
        caminhoComPeso.append(" => ");
        caminhoComPeso.append("(");
        caminho.stream()
                .forEach(vertice -> {
                    caminhoComPeso.append(vertice);
                    if (!vertice.getTitulo().equals(destino.getTitulo()))
                        caminhoComPeso.append(" ~> ");
                });
        caminhoComPeso.append(")");
        caminhoComPeso.append(" :: Peso = ");
        caminhoComPeso.append(peso);

        return caminhoComPeso.toString();
    }

    public void imprimirTodosCaminhos() {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.println(getCaminhoPeso(vertices.get(i), vertices.get(j)));
            }
        }
    }

    public void menorDistanciaEntre(Vertice origem, Vertice destino) {
        JOptionPane.showMessageDialog(null, getCaminhoPeso(origem, destino));
    }
}
