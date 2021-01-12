package com.example.projetophoebus.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "historico")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hist;
	
	@NotNull
	@Column(name = "data_status")
	private LocalDate datastatus;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name ="fk_hospital")
	private Hospital hospital;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name ="fk_recurso")
	private Recurso recurso;

	public Long getId_hist() {
		return id_hist;
	}

	public void setId_hist(Long id_hist) {
		this.id_hist = id_hist;
	}

	public LocalDate getData_status() {
		return datastatus;
	}

	public void setData_status(LocalDate data_status) {
		this.datastatus = data_status;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_hist == null) ? 0 : id_hist.hashCode());
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
		Historico other = (Historico) obj;
		if (id_hist == null) {
			if (other.id_hist != null)
				return false;
		} else if (!id_hist.equals(other.id_hist))
			return false;
		return true;
	}
	
}
