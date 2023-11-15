package com.FGRW.tfpi.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Ranking {
	private String localidade;
	private String sexo;
	private ArrayList<Nome> res;
	
	public Ranking() {
		super();
	}
	public Ranking(String localidade, String sexo, ArrayList<Nome> res) {
		super();
		this.localidade = localidade;
		this.sexo = sexo;
		this.res = res;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public ArrayList<Nome> getRes() {
		return res;
	}
	public void setRes(ArrayList<Nome> res) {
		this.res = res;
	}
	public void addRes(Nome res) {
		this.res.add(res);
	}
	@Override
	public int hashCode() {
		return Objects.hash(localidade, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ranking other = (Ranking) obj;
		return Objects.equals(localidade, other.localidade) && Objects.equals(sexo, other.sexo);
	}
	@Override
	public String toString() {
		return "Ranking [localidade=" + localidade + ", sexo=" + sexo + ", res=" + res + "]";
	}
	
	
}
