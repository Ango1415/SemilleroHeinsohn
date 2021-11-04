package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculo;

/**
 * 
 * <b>Descripción:</b> Clase que determina como se heredan las clases abstractas
 * <b>Caso de Uso:</b> SEMILLERO2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class AvionHeredaAbstracta extends AccionesVehiculo {
	
	//Se tienen que implementar los métodos firmados en la clase abstracta

	@Override
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long obtenerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
