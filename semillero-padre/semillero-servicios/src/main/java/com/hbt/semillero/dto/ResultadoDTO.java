package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Indica el resultado de ejecución. Si es exitosa o no muestra un mensaje para el cliente,
 * la transaccion no es excitosa si generamos una excepción funcional. (p ejm hay un comic repetido)
 * 
 * @author Johnny Soto
 *
 */
public class ResultadoDTO implements Serializable {

	/**
	 * Atributo que determina el serial con el que se identificara el DTO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Indicador de resultado.
	 */
	private boolean exitoso = false;
	/**
	 * Mensaje de ejecución.
	 */
	private String mensajeEjecucion;

	
	/**
	 * 
	 * Constructor de la clase., está vacío
	 */
	public ResultadoDTO() {
		//Constructor vacío de la clase
	}
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param exitoso
	 * @param mensajeEjecucion
	 */
	public ResultadoDTO(boolean exitoso, String mensajeEjecucion) {
		super();
		this.exitoso = exitoso;
		this.mensajeEjecucion = mensajeEjecucion;
	}

	/**
	 * Método que obtiene el valor de la propiedad exitoso
	 * 
	 * @return the exitoso
	 */
	public boolean isExitoso() {
		return exitoso;
	}

	/**
	 * Método que asigna el valor de la propiedad exitoso
	 * 
	 * @param exitoso the exitoso to set
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	/**
	 * Método que obtiene el valor de la propiedad mensajeEjecucion
	 * 
	 * @return the mensajeEjecucion
	 */
	public String getMensajeEjecucion() {
		return mensajeEjecucion;
	}

	/**
	 * Método que asigna el valor de la propiedad mensajeEjecucion
	 * 
	 * @param mensajeEjecucion the mensajeEjecucion to set
	 */
	public void setMensajeEjecucion(String mensajeEjecucion) {
		this.mensajeEjecucion = mensajeEjecucion;
	}

}
