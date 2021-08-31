package br.edu.ifs.vaniltonfilho.main.arvore;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	private static List<Vertice> criarGrafo() {
	    List<Vertice> grafo = new ArrayList<>();
	    Vertice a = new Vertice("A");
	    Vertice b = new Vertice("B");
	    Vertice c = new Vertice("C");
	    Vertice d = new Vertice("D");
	    Vertice e = new Vertice("E");
	    
	    Aresta ab = new Aresta(2); 
	    a.adicionarAresta(b, ab);
	    b.adicionarAresta(a, ab);

	    Aresta be = new Aresta(5);
	    b.adicionarAresta(e, be);
	    e.adicionarAresta(b, be);
	    
	    Aresta bc = new Aresta(2);
	    b.adicionarAresta(c, bc);
	    c.adicionarAresta(b, bc);
	    
	    Aresta ac = new Aresta(3);
	    a.adicionarAresta(c, ac);
	    c.adicionarAresta(a, ac);
	    
	    Aresta ce = new Aresta(1);
	    c.adicionarAresta(e, ce);
	    e.adicionarAresta(c, ce);
	    
	    Aresta cd = new Aresta(1);
	    c.adicionarAresta(d, cd);
	    d.adicionarAresta(c, cd);
	    
	    grafo.add(a);
	    grafo.add(b);
	    grafo.add(c);
	    grafo.add(d);
	    grafo.add(e);

	    return grafo;
	}
	
	public static void main(String[] args) {
		AlgoritmoPrim prim = new AlgoritmoPrim(criarGrafo());
		StringBuilder sb = new StringBuilder();
		
		sb.append("Grafo original: \n");
		sb.append(prim.grafoOriginal() + "\n\n");
		sb.append("Árvore geradora minima: \n");
		
		prim.executar();
		prim.resetPrint();
		sb.append(prim.arvoreGeradoraMinima());
		JOptionPane.showMessageDialog(null, sb.toString());
	}
}
