package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Enumerador que determina el color en la clase Vehiculo
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public enum ColorPrimarioEnum {
	
	AMARILLO("Amarillo"),
	AZUL("Azul"),
	ROJO("Rojo"),
	VERDE("Verde"),
	GRIS("Gris");
	
	/**
	 * Atributo que define el color del enumerador
	 */
	private String color;
	
	
	
	/**
	 * 
	 * Constructor del enumerador.
	 * @param color
	 */
	ColorPrimarioEnum(String color) {
		this.color=color;
	}
	
	
	
	/**
	 * 
	 * Metodo encargado de retornar el color del enumerador 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return color Color del enumerador
	 */
	public String getColor() {
		return this.color;
	}

}
