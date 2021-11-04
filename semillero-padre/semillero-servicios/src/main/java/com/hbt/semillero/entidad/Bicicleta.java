package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:</b> Clase que determina la abstraccion de una bicileta, hereda de vehiculo
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class Bicicleta extends Vehiculo implements AccionesVehiculoInterface {
	
	/**
	 * Atributo que determina el tipo de bicicleta
	 */
	private String tipoBicicleta;
	
	/**
	 * Atributo que determina si se requiere de chaleco para utilizar la bicicleta
	 */
	private boolean utilizaChalecoReflector;

	
	
	/**
	 * Constructor de la clase.
	 */
	public Bicicleta() {
		//Constructor vacio de la clase
		super();
	}

	
	
	/**
	 * Metodo encargado de retornar el valor del atributo tipoBicicleta
	 * @return El tipoBicicleta asociado a la clase
	 */
	public String getTipoBicicleta() {
		return tipoBicicleta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tipoBicicleta
	 * @param tipoBicicleta El nuevo tipoBicicleta a modificar.
	 */
	public void setTipoBicicleta(String tipoBicicleta) {
		this.tipoBicicleta = tipoBicicleta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo utilizaChalecoReflector
	 * @return El utilizaChalecoReflector asociado a la clase
	 */
	public boolean isUtilizaChalecoReflector() {
		return utilizaChalecoReflector;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo utilizaChalecoReflector
	 * @param utilizaChalecoReflector El nuevo utilizaChalecoReflector a modificar.
	 */
	public void setUtilizaChalecoReflector(boolean utilizaChalecoReflector) {
		this.utilizaChalecoReflector = utilizaChalecoReflector;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerVelocidadMaxima()
	 */
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	/**
	 * 
	 * @see com.hbt.semillero.interfaces.AccionesVehiculoInterface#obtenerPesoMaximoCarga()
	 */
	public Long obtenerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return 40L;
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