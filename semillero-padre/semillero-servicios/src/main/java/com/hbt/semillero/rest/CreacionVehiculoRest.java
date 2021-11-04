package com.hbt.semillero.rest;

import java.math.BigDecimal;

import com.hbt.semillero.entidad.Avion;
import com.hbt.semillero.entidad.Barco;
import com.hbt.semillero.entidad.Bicicleta;
import com.hbt.semillero.entidad.Vehiculo;
import com.hbt.semillero.enums.ColorPrimarioEnum;
import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Clase para invocar las funcionalidades del la clase vehiculo
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class CreacionVehiculoRest {

	/**
	 * Metodo Main encargado de ejecutar las funcionalidades de la clase vehículo
	 * <b>Caso de Uso</b> Semillero 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo(ColorPrimarioEnum.ROJO, new BigDecimal(20000));
		Vehiculo vehiculo1 = new Vehiculo();
		
		vehiculo1.setColor(ColorPrimarioEnum.AZUL);
		vehiculo1.setNumeroAsientos(2);
		vehiculo1.setNumeroLlantas(4);
		vehiculo1.setPrecio(new BigDecimal(50000));
		vehiculo1.setRequiereLicencia(true);
		vehiculo1.setTipoVehiculo(TipoVehiculoEnum.TERRESTRE);
		
		vehiculo.setColor(ColorPrimarioEnum.AZUL);
		vehiculo.setPrecio(new BigDecimal(30000));
		
		Avion avion1 = new Avion();
		avion1.setTipoVehiculo(TipoVehiculoEnum.AEREO);
		
		Barco barco1 = new Barco();
		barco1.setColor(ColorPrimarioEnum.AMARILLO);
		barco1.setNumeroAsientos(20);
		barco1.setNumeroLlantas(0);
		barco1.setPrecio(new BigDecimal(500000));
		barco1.setRequiereLicencia(true);
		barco1.setTipoVehiculo(TipoVehiculoEnum.ACUATICO);
		
		Bicicleta bicicleta1 = new Bicicleta();
		bicicleta1.setTipoVehiculo(TipoVehiculoEnum.TERRESTRE);
		
		
		System.out.println(vehiculo1.toString());
		System.out.println(barco1.toString());
		System.out.println("La velocidad del BARCO es:" + barco1.obtenerVelocidadMaxima());
		barco1.acelerar();
		System.out.println("La velocidad de la BICICLETA es:" + bicicleta1.obtenerVelocidadMaxima());
		bicicleta1.acelerar();
		
		
		try {
			avion1.determinarTipoVehiculo(TipoVehiculoEnum.TERRESTRE);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			avion1.determinarTipoVehiculo(TipoVehiculoEnum.AEREO);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}