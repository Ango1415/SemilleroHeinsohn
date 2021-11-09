package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <b>Descripción:</b> Clase que determina el DTO que se obtiene al llamar el método consultarNombrePrecioComic()
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class ConsultarNombrePrecioComicDTO extends ResultadoDTO implements Serializable {
	
	/**
	 * Atributo que determina el serial con el que se identificara el DTO  
	 */
	private static final long serialVersionUID = 1L; //Recuerde que todos los DTO y Entidades deben tener un serial para la comunicación con la BD

	/**
	 * Atributo que determina el nombre del Comic consultado
	 */
	private String nombre;
	
	/**
	 * Atributo que determina el precio del Comic consultado
	 */
	private BigDecimal precio;
	

	/**
	 * 
	 * Constructor de la clase, está vacío
	 */
	public ConsultarNombrePrecioComicDTO () {
		//Constructor vacío de la clase
		super();
	}
	
	/**
	 * 
	 * Constructor parametrizado de la clase.
	 * @param nombre
	 * @param precio
	 */
	public ConsultarNombrePrecioComicDTO (String nombre, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
