package br.edu.ifs.vaniltonfilho.main.busca;

import java.util.List;

public class Pesos {
	private Double custo;
	private Double lentidao;
	private Double risco;
	
	public Pesos(double custo, double lentidao, double risco) {
		this.custo = custo;
		this.lentidao = lentidao;
		this.risco = risco;
	}
	
	public Pesos(List<Double> valores) {
		this.custo = valores.get(0);
		this.lentidao = valores.get(1);
		this.risco = valores.get(2);
	}
	
	public Double media() {
		return (custo + lentidao + risco) / 3;
	}
	
	public Double soma() {
		return (custo + lentidao + risco);
	}
	
	
	public Double getCusto() {
		return custo;
	}
	
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	public Double getLentidao() {
		return lentidao;
	}
	
	public void setLentidao(Double lentidao) {
		this.lentidao = lentidao;
	}
	
	public Double getRisco() {
		return risco;
	}
	
	public void setRisco(Double risco) {
		this.risco = risco;
	}
}
