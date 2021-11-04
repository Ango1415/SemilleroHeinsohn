package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina la enumeracion para representar los
 * estados aceptados en un comic
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public enum EstadoEnum {
	
	ACTIVO("enum.estado.activo"),  
	INACTIVO("enum.estado.inactivo");

	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;
	
	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	EstadoEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * 
	 * Metodo encargado de obtener un valor
	 * @return codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}
}
