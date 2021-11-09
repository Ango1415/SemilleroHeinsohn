package com.hbt.semillero.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <b>Descripción:</b> Clase DTO que determina los elementos que pertenecen a la consulta de todos los comics
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
public class ConsultarComicsDTO extends ResultadoDTO implements Serializable{

	/**
	 * Atributo que determina el serial con el que se identificara el DTO  
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo que determina todos los comics que pertenecen a la tabla COMICS
	 */
	private List<ComicDTO> listaComicsDTO;

	
	/**
	 * Constructor parametrizado de la clase.
	 * @param listaComicsDTO
	 */
	public ConsultarComicsDTO() {
		super();
		this.listaComicsDTO = new ArrayList<>();
	}
	
	/**
	 * Constructor parametrizado de la clase.
	 * @param listaComicsDTO
	 */
	public ConsultarComicsDTO(List<ComicDTO> listaComicsDTO) {
		super();
		this.listaComicsDTO = listaComicsDTO;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicsDTO
	 * @return listaComicsDTO asociado a la clase
	 */
	public List<ComicDTO> getListaComicsDTO() {
		return listaComicsDTO;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicsDTO
	 * @param listaComicsDTO El nuevo listaComicsDTO a modificar.
	 */
	public void setListaComicsDTO(List<ComicDTO> listaComicsDTO) {
		this.listaComicsDTO = listaComicsDTO;
	}
	
	
	
}
