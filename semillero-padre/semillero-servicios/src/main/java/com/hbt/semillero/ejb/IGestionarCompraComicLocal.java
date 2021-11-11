/**
 * IGestionarCompraComicLocal.java
 */
package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
/**
 * 
 * <b>Descripción:</b> Interfaz que determina la firma de los métodos que usaremos en el Bean y REST del servicio GestionarCompraComicLocal
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
@Local
public interface IGestionarCompraComicLocal {
	
	/**
	 * 
	 * Metodo encargado de realizar la accion de comprar un Comic con su respectiva logica en el proceso: Encontrar el comic,
	 * ver si hay stock, descontar los comics solicitados, retornar el estado del comic.
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param cantidadCompra Es la cantidad de Comics que se desea comprar
	 * @param comicAComprarDTO Es el DTO del Comic que se desea comprar.
	 * @return resultadoDTO es el resultado del Comic que se desea comprar, en formato DTO
	 */
	public ComicDTO comprarComic(Integer cantidadCompra, ComicDTO comicAComprarDTO) throws Exception;

}
