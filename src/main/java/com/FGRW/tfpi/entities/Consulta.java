package com.FGRW.tfpi.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String session;
	private String dataInicial;
	private String dataFinal;
	private String sexo;
	private String localidade;
	
	public Consulta() {
	}
	
	public Consulta(Long id, String session, String dataInicial, String dataFinal, String sexo, String localidade) {
		super();
		this.id = id;
		this.session = session;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.sexo = sexo;
		this.localidade = localidade;
	}


	public Long getId() {
		return id;
	}

	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFinal, dataInicial, id, localidade, session, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(dataFinal, other.dataFinal) && Objects.equals(dataInicial, other.dataInicial)
				&& Objects.equals(id, other.id) && Objects.equals(localidade, other.localidade)
				&& Objects.equals(session, other.session) && Objects.equals(sexo, other.sexo);
	}
	
	
	
}
