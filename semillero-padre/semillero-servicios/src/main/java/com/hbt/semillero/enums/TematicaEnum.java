package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:</b> Clase que determina la enumeracion para representar los tipos de tematica aceptados por un comic
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public enum TematicaEnum {
	
	AVENTURAS("enum.tematica.aventuras"), //El valor de la descrp lo dejamos así porque es un ejemplo de como se usan en listas despregables en el front, a esto se le llama internazionalizacion
	BELICO("enum.tematica.belico"),
	HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"),
	HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror")
	;
	
	private String descipcion;
	
	
	/**
	 * 
	 * Constructor de la clase enumerador.
	 * @param descripcion
	 */
	TematicaEnum(String descripcion){
		this.descipcion=descripcion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo descipcion
	 * @return El descipcion asociado a la clase
	 */
	public String getDescipcion() {
		return descipcion;
	}

}
