package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:</b> Clase que determina las caracteristicas de un Avion, hereda de vehiculo
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class Avion extends Vehiculo implements AccionesVehiculoInterface{

	/**
	 * 
	 * Constructor de la clase.
	 */
	public Avion() {
		//Constructor vacio de la clase
		super();
	}
	
	
	
	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerVelocidadMaxima()
	 */
	public int obtenerVelocidadMaxima() {
		return 700;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerPesoMaximoCarga()
	 */
	public Long obtenerPesoMaximoCarga() {
		return 50L;
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
