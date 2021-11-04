package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Enumerador que determina el tipo de vehículo en la clase Vehiculo
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public enum TipoVehiculoEnum {
	
	TERRESTRE("Terrestre", 01),
	ACUATICO("Acuatico", 02),
	AEREO("Aereo", 03);
	
	/**
	 * Atributo del enumerador para definir el tipo de vehiculo
	 */
	private String descripcion;
	
	/**
	 * Atributo correspondiente al identificador numérico del tipo de vehiculo
	 */
	private int identificador;
	
	
	
	/**
	 * 
	 * Constructor del enumerador.
	 * @param descripcion Tipo del vehiculo
	 * @param identificador Valor numerico utilziado para identificar el tipo de vehiculo
	 */
	TipoVehiculoEnum(String descripcion, int identificador){ //No lleva visibilidad porque por defecto es private
		this.descripcion=descripcion;
		this.identificador=identificador;
	}
	
	
	
	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo tipo del enumerador 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return descripcion Tipo del enumerador
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * 
	 * Metodo encargado de retornar el valor del identificador del tipo del enumerador 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return identificador Valor numerico para identificar el tipo de vehiculo
	 */
	public int getIdentificador() {
		return this.identificador;
	}
	
	//Los enumeradores NO llevan métodos set
}

/*
 
package com.hbt.semillero.enums;

public enum TipoVehiculoEnum {
	TERRESTRE("Terrestre",1),
	ACUATICO("Acuatico",2),
	AEREO("aereo",3);
	
	private String tipo;
	private int identificador;
	
	TipoVehiculoEnum(String tipo, int identificador) {
		this.tipo =tipo;
		this.identificador =identificador;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo identificador
	 * @return El identificador asociado a la clase
	 *
	public int getIdentificador() {
		return identificador;
	}
	
	public String getTipo() {
		return tipo;
	}
}
*/