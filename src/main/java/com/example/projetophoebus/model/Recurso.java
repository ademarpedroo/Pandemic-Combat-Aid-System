package com.example.projetophoebus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recurso")
public class Recurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_recurso;
	
	private String nome;
	
	private String ponto;

	public Long getId_recurso() {
		return id_recurso;
	}

	public void setId_recurso(Long id_recurso) {
		this.id_recurso = id_recurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPonto() {
		return ponto;
	}

	public void setPonto(String ponto) {
		this.ponto = ponto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_recurso == null) ? 0 : id_recurso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recurso other = (Recurso) obj;
		if (id_recurso == null) {
			if (other.id_recurso != null)
				return false;
		} else if (!id_recurso.equals(other.id_recurso))
			return false;
		return true;
	}

	
}
