package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:</b> Clase que determina las caracteristicas de un barco, hereda de vehiculo
 * <b>Caso de Uso:</b> SEMILLERO 2021 
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class Barco extends Vehiculo implements AccionesVehiculoInterface{
	
	/**
	 * Atributo que determina el nombre del capitan del barco
	 */
	private String nombreCapitan;
	
	/**
	 * Atributo que determina el puerto al que ha de llegar el barco 
	 */
	private String puertoDeLlegada;
	
	
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Barco() {
		//Constructor vacio de la clase
		super();
	}
	
	

	
	/**
	 * Metodo encargado de retornar el valor del atributo nombreCapitan
	 * @return El nombreCapitan asociado a la clase
	 */
	public String getNombreCapitan() {
		return nombreCapitan;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombreCapitan
	 * @param nombreCapitan El nuevo nombreCapitan a modificar.
	 */
	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo puertoDeLlegada
	 * @return El puertoDeLlegada asociado a la clase
	 */
	public String getPuertoDeLlegada() {
		return puertoDeLlegada;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo puertoDeLlegada
	 * @param puertoDeLlegada El nuevo puertoDeLlegada a modificar.
	 */
	public void setPuertoDeLlegada(String puertoDeLlegada) {
		this.puertoDeLlegada = puertoDeLlegada;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerVelocidadMaxima()
	 */
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerPesoMaximoCarga()
	 */
	public Long obtenerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return 60L;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#determinarTipoVehiculo(com.hbt.semillero.enums.TipoVehiculoEnum)
	 */
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception {
		
		//Se usa igual igual porque comparamos los identificadores de los tipos, que en este caso son enteros
		if(this.getTipoVehiculo().getIdentificador() == tipoVehiculoEnum.getIdentificador()) {
			System.out.println("El vehiculo si es de ese tipo");
			return true;
		}
		else {
			throw new Exception("El tipo de vehiculo asignado es erroneo, debe ser " + this.getTipoVehiculo().getDescripcion());
		}		
	}

}
