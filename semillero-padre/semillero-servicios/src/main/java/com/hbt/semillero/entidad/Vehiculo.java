package com.hbt.semillero.entidad;

import java.math.BigDecimal;

import com.hbt.semillero.enums.ColorPrimarioEnum;
import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Clase que determina la representacion de las características en común de un vehículo
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author ÁNGEL GÓMEZ
 * @version 1.0
 */
public class Vehiculo {
	
	/**
	 * Atributo que determina el color del vehiculo
	 */
	private ColorPrimarioEnum color;
	
	/**
	 * Atributo que determina el tipo del vehiculo
	 */
	private TipoVehiculoEnum tipoVehiculo;
	
	/**
	 * Atributo que determina el número de llantas del vehículo
	 */
	private int numeroLlantas;
	
	/**
	 * Atributo que determina el número de asientos del vehículo
	 */
	private int numeroAsientos;
	
	/**
	 * Atributo que determina si para conducir el vehículo se requiere de licencia
	 */
	private boolean requiereLicencia;
	
	/**
	 * Atributo que determina el precio total del vehículo
	 */
	private BigDecimal precio; //BigDecimal es importante porque se usa para cuentas monetarias
	
	
	
	/**
	 * Constructor vacío de la clase.
	 */
	public Vehiculo() {
		//Este es un constructor vacío
	}
	
	/**
	 * Constructor parametrizado de la clase.
	 * @param color Determina el color del vehiculo
	 * @param precio Determina el precio total del vehículo
	 */
	public Vehiculo(ColorPrimarioEnum color, BigDecimal precio) {
		this.color=color;
		this.precio=precio;
	}
	
	
	
	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public ColorPrimarioEnum getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(ColorPrimarioEnum color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tipoVehiculo
	 * @return El tipoVehiculo asociado a la clase
	 */
	public TipoVehiculoEnum getTipoVehiculo() {
		return tipoVehiculo;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tipoVehiculo
	 * @param tipoVehiculo El nuevo tipoVehiculo a modificar.
	 */
	public void setTipoVehiculo(TipoVehiculoEnum tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroLlantas
	 * @return El numeroLlantas asociado a la clase
	 */
	public int getNumeroLlantas() {
		return numeroLlantas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroLlantas
	 * @param numeroLlantas El nuevo numeroLlantas a modificar.
	 */
	public void setNumeroLlantas(int numeroLlantas) {
		this.numeroLlantas = numeroLlantas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroAsientos
	 * @return El numeroAsientos asociado a la clase
	 */
	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroAsientos
	 * @param numeroAsientos El nuevo numeroAsientos a modificar.
	 */
	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo requiereLicencia
	 * @return El requiereLicencia asociado a la clase
	 */
	public boolean isRequiereLicencia() {
		return requiereLicencia;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo requiereLicencia
	 * @param requiereLicencia El nuevo requiereLicencia a modificar.
	 */
	public void setRequiereLicencia(boolean requiereLicencia) {
		this.requiereLicencia = requiereLicencia;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
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

	/** 
	 * Método toString para ver los valores de los parametros de un objeto instanciado
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [color=" + color + ", tipoVehiculo=" + tipoVehiculo + ", numeroLlantas=" + numeroLlantas
				+ ", numeroAsientos=" + numeroAsientos + ", requiereLicencia=" + requiereLicencia + ", precio=" + precio
				+ "]";
	}
}