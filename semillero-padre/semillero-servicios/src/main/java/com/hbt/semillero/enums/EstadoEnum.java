package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina la enumeracion para representar los
 * estados aceptados en un comic
 * 
 * @author ccastano
 * @v
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
	 * <b>Caso de Uso</b>
	 * @author angel
	 * 
	 * @return
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * 
	 * Metodo encargado de establecer un valor
	 * <b>Caso de Uso</b>
	 * @author angel
	 * 
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
