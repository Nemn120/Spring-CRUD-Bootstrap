package com.springboot.club.app.models.entity;

public enum Pais {
	
	ESPAÑA ("España"),
	MEXICO ("Mexico"),
	PERÚ ("Peru"),
	CHILE ("Chile"),
	ARGENTINA ("Argentina"),
	BRASIL ("Brasil"),
	ALEMANIA ("Alemania"),
	INGLATERRA ("Inglaterra"),
	ITALIA ("Italia"),
	PORTUGAL ("Portugal"),
	FRANCIA ("Francia"),
	COLOMBIA ("Colombia"),
	NIGERIA ("Nigeria"),
	CROACIA ("Croacia"),
	SERBIA ("Serbia"),
	VENEZUELA ("Venezuela"),
	ARGELIA ("Argelia");
	
	private final String name;
	
	Pais(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
