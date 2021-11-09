package com.hbt.semillero.dto;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Descripción:</b> Clase que determina el DTO relacionado a la consulta que filtra el nombre de cada Comic de acuerdo a su tamaño
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0 
 */
public class ConsultarComicTamanioNombreDTO extends ResultadoDTO implements Serializable{

	/**
	 * Atributo que determina el numero serial con el que se identifica el DTO  
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo que determina la lista de Comics que igualan o superan la longitud en sus nombre de acuerdo al parametro recibido
	 */
	private List<ComicDTO> listaSuperaLongitud;
	
	/**
	 * Atributo que determina la lista de Comics que no igualan ni superan la longitud en sus nombre de acuerdo al parametro recibido
	 */
	private List<ComicDTO> listaNoSuperaLongitud;


	/**
	 * Metodo encargado de retornar el valor del atributo listaSuperaLongitud
	 * @return listaSuperaLongitud asociado a la clase
	 */
	public List<ComicDTO> getListaSuperaLongitud() {
		return listaSuperaLongitud;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaSuperaLongitud
	 * @param listaSuperaLongitud El nuevo listaSuperaLongitud a modificar.
	 */
	public void setListaSuperaLongitud(List<ComicDTO> listaSuperaLongitud) {
		this.listaSuperaLongitud = listaSuperaLongitud;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaNoSuperaLongitud
	 * @return listaNoSuperaLongitud asociado a la clase
	 */
	public List<ComicDTO> getListaNoSuperaLongitud() {
		return listaNoSuperaLongitud;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaNoSuperaLongitud
	 * @param listaNoSuperaLongitud El nuevo listaNoSuperaLongitud a modificar.
	 */
	public void setListaNoSuperaLongitud(List<ComicDTO> listaNoSuperaLongitud) {
		this.listaNoSuperaLongitud = listaNoSuperaLongitud;
	}
	
	
	
	

}
