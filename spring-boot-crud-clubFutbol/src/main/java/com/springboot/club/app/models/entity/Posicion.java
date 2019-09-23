package com.springboot.club.app.models.entity;

public enum Posicion {
	
	
	PORTERO ("Portero"),
	LIBERO ("Libero"),
	CENTRAL ("Central"),
	LATERAL ("Lateral"),
	CARRILERO ("Carrilero"),
	PIVOTE ("Pivote"),
	INTERIOR ("Interior"),
	VOLANTE ("Volante"),
	MEDIA_PUNTA ("Media Punta"),
	SEGUNDO_DELANTERO ("Segundo Delantero"),
	DELANTERO_CENTRO ("Delantero Centro"),
	EXTREMO ("Extremo");
	
	private final String name;
	
	Posicion(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	

}
