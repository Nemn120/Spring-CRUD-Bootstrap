package com.springboot.club.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAS")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String ciudad;
	private String DNI;
	private Pais pais;
	
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDNI() {
		return DNI;
	}
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
