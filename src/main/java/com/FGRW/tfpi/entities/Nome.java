package com.FGRW.tfpi.entities;

import java.util.Objects;

public class Nome {
	private String nome;
	private String frequencia;
	private Integer ranking;
	
	public Nome() {
	}
	
	public Nome(String nome, String frequencia, Integer ranking) {
		super();
		this.nome = nome;
		this.frequencia = frequencia;
		this.ranking = ranking;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	@Override
	public int hashCode() {
		return Objects.hash(frequencia, nome, ranking);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nome other = (Nome) obj;
		return Objects.equals(frequencia, other.frequencia) && Objects.equals(nome, other.nome)
				&& Objects.equals(ranking, other.ranking);
	}
	@Override
	public String toString() {
		return "Nome [nome=" + nome + ", frequencia=" + frequencia + ", ranking=" + ranking + "]";
	}
	
}
