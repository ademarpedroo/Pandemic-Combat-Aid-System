package com.example.projetophoebus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hosp_rec")
public class HospitalRecurso {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hosp_rec;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name ="fk_hospital")
	private Hospital hospital;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name ="fk_recurso")
	private Recurso recurso;
	
	@NotNull
	private Integer quantidade;
	
	
	
	public Long getId_hosp_rec() {
		return id_hosp_rec;
	}

	public void setId_hosp_rec(Long id_hosp_rec) {
		this.id_hosp_rec = id_hosp_rec;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_hosp_rec == null) ? 0 : id_hosp_rec.hashCode());
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
		HospitalRecurso other = (HospitalRecurso) obj;
		if (id_hosp_rec == null) {
			if (other.id_hosp_rec != null)
				return false;
		} else if (!id_hosp_rec.equals(other.id_hosp_rec))
			return false;
		return true;
	}

	
}
