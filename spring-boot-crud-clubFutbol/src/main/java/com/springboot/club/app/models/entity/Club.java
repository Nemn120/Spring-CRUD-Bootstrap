package com.springboot.club.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLUBS")
public class Club implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Pais pais;
	private String estadio;
	
	@OneToOne
	@JoinColumn(name="ID_ENTRENADOR")
	private Entrenador entrenador;
	private Integer fondo;
	@OneToMany(mappedBy = "club", cascade=CascadeType.ALL)
	private List<Futbolista> futbolistas = new ArrayList<Futbolista>();
	
	public Club(){
	
	}
	
	public List<Futbolista> getFutbolistas() {
		return futbolistas;
	}
	public void setFutbolistas(List<Futbolista> futbolistas) {
		this.futbolistas = futbolistas;
	}
	public Long getId() {
		return id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getFondo() {
		return fondo;
	}
	public void setFondo(Integer fondo) {
		this.fondo = fondo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

}
