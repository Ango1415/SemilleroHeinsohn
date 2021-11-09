package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultarComicsDTO;
import com.hbt.semillero.dto.ConsultarNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * 
 * <b>Descripción:</b> Interfaz que determina la firma de los métodos relacionados con el CRUD de Gestionar Comic
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
@Local
public interface IGestionarComicLocal {
	
	//Recuerde que retornan un ResultadoDTO porque esa clase se creo específicamente para generar mensajes de error o transacción dicientes para el usuario de la app
	
	/**
	 * 
	 * Metodo encargado de consultar un registro de acuerdo a su nombre y su precio
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comicDTO
	 * @return
	 */
	public ConsultarNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de crear un comic de acuerdo a la información recibida en ComicDTO 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comicDTO
	 * @return
	 */
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de actualizar un registro de la tabla COMIC
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param idComic
	 * @return
	 */
	public ComicDTO actualizarComic(Long idComic, ComicDTO comicDTO) throws Exception;
	
	
	/**
	 * 
	 * Metodo encargado de eliminar un registro de la tabla COMIC
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param idComic
	 * @return
	 */
	public ResultadoDTO eliminarComic(Long idComic) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de consultar un conjunto de registros en la tabla COMIC
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return
	 */
	public ConsultarComicsDTO consultarComics() throws Exception;
	
	/**
	 * 
	 * Metodo encargado de consultar que Comics sobrepasan la longitud en sus nombres dada por el usuario y cuales otros no
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param lenghtComic
	 * @return
	 * @throws Exception
	 */
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lenghtComic) throws Exception;
	
}

