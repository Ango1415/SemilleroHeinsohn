/**
 * GestionarCompraComicBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * <b>Descripción:</b> Clase que determina la parte Bean del servicio GestionarCompraComic, acá tenemos gran parte de la aprte
 * lógica de los métodos usados
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComicLocal {
	
	/**
	 * Atributo que gestiona la conexión con la BD para hacer transacciones y consultas
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraComicLocal#comprarComic(java.lang.Integer, com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ComicDTO comprarComic(Integer cantidadCompra, ComicDTO comicAComprarDTO) throws Exception {
		
		//Realizo la busqueda del Comic a comprar
		String consultaComic = " SELECT c FROM Comic c WHERE c.nombre = :nombre ";
		Query queryComic = em.createQuery(consultaComic);
		queryComic.setParameter("nombre", comicAComprarDTO.getNombre());
		Comic comic = (Comic) queryComic.getSingleResult();
		
		ComicDTO comicDTO = this.convertirComicToComicDTO(comic);
		
		//Compruebo que el Comic esté activo
		if(comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) { 
			throw new Exception("El comic seleccionado no cuenta con stock en bodega");
			
		}else if (cantidadCompra > comicDTO.getCantidad()) {
			throw new Exception("La cantidad existente del comic es: " + comicDTO.getCantidad() + " y no supera la ingresada");
			
		}else { //Realizo esta estructura porque a partir de este punto si o si haré un merge, me ahorro lineas de código
			
			if(cantidadCompra.equals(comicDTO.getCantidad())) {
				comicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
				comicDTO.setFechaVenta(LocalDate.now());
				comicDTO.setCantidad(0);
				
			}else {
				Integer total = comicDTO.getCantidad() - cantidadCompra;
				comicDTO.setFechaVenta(LocalDate.now());
				comicDTO.setCantidad(total);
				
			}
			
			//Convierto el comicDTO para poder hacer la transaccion
			comic = this.convertirComicDTOToComic(comicDTO);
			em.merge(comic);
		}		
		
		return comicDTO;
	}
	
	
	/**
	 * 
	 * Metodo encargado de convertir un ComicDTO en una entidad Comic 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comic Entidad Comic
	 * @return comicDTO DTO de la entidad Comic
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
	
		ComicDTO comicDTO = new ComicDTO();
		
		comicDTO.setId(comic.getId());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setCantidad(comic.getCantidad());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setColor(comic.getColor());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		
		return comicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un Comic en una entidad ComicDTO 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comicDTO DTO de la entidad Comic
	 * @return comic Entidad Comic
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		
		Comic comic = new Comic();
		
		comic.setId(comicDTO.getId());
		comic.setAutores(comicDTO.getAutores());
		comic.setCantidad(comicDTO.getCantidad());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setColor(comicDTO.getColor());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setNombre(comicDTO.getNombre());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		
		return comic;
	}
}
