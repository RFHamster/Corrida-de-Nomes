package com.FGRW.tfpi.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estado")
public class Estados {
	@Id
	private String sigla;
	private String id;
	private String nome;
	
	public Estados() {
	}
	
	public Estados(String sigla, String id, String nome) {
		super();
		this.sigla = sigla;
		this.id = id;
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String estado) {
		this.sigla = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sigla, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estados other = (Estados) obj;
		return Objects.equals(sigla, other.sigla) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Estados [sigla=" + sigla + ", id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
}
