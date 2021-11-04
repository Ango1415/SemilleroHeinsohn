package com.hbt.semillero.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * 
 * <b>Descripción:</b> Interfaz que determina las acciones que puede realizar un vehiculo
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public interface AccionesVehiculoInterface {
	
	//En una interfaz TODOS los metodos son abstractos, por lo que no se debe poner la palabra abstract
	//En la firma de los mismos, en la clase abstracta SI se debe definir los métodos como abstractos.
	
	/**
	 * 
	 * Metodo abstracto encargado de retornar la velocidad maxima del vehiculo 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOEMZ
	 * 
	 * @return
	 */
	public int obtenerVelocidadMaxima(); //Esto es simplemente la firma de un metodo, quienes
	//implementen la clase deben definir el método en sus clases
	
	/**
	 * 
	 * Metodo abstracto encargado de retornar el valor del peso maximo que soporta el vehiculo 
	 * <b>Caso de Uso</b>
	 * @author angel
	 * 
	 * @return
	 */
	public Long obtenerPesoMaximoCarga();
	
	/**
	 * 
	 * Metodo encargado de determinar si el tipo de vehiculo es el indicado por eso usuario
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param tipoVehiculoEnum Tipo de vehiculo dado por el usuario
	 * @return
	 * @throws Exception Excepcion ante un posible error
	 */
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception; //retorna el boolean o la excepcion
	
	/**
	 * 
	 * Metodo encargado de realizar la aceleracion de un vehiculo 
	 * <b>Caso de Uso</b>
	 * @author angel
	 *
	 */
	public default void acelerar() {
		//Note que este metodo si tiene implementada funcionalidad, a diferencia de las otras firmas
		//que son abstractas
		System.out.println("El vehiculo acelera...");
	}

}
