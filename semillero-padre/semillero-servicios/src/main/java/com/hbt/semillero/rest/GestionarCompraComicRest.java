/**
 * GestionarCompraComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarCompraComicLocal;

/**
 * <b>Descripción:</b> Clase que determina la parte REST del servicio GestionarCompraComic
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0 
 */
@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	
	/**
	 * Atributo que nos permite acceder al log, nos sirve para poder anviar mensajes en la consola a medida que realizamos debug
	 */
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
	
	/**
	 * Atributo que determina la interfaz que nos permite desarrollar la lógica de nuestro servicio.
	 */
	@EJB
	private IGestionarCompraComicLocal iGestionarCompraComicLocal;
	
	/**
	 * 
	 * Constructor vacío de la clase.
	 */
	public GestionarCompraComicRest() {
		BasicConfigurator.configure();
	}
	
	/**
	 * 
	 * Metodo encargado de definir el servicio comprarComic, el cual consulta la disponibilidad de un comic desdeado,
	 * y en caso de que haya stock, compra el comic
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param cantidadCompra Es la cantidad de Comics que se desea comprar
	 * @param comicAComprarDTO Es el DTO del Comic que se desea comprar.
	 * @return comicDTO es el resultado del Comic que se desea comprar, en formato DTO
	 */
	@POST
	@Path("/comprarComic") //Siempre es el nombre que se le da al servicio
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO comprarComic(@QueryParam("cantidadCompra") Integer cantidadCompra, ComicDTO comicAComprarDTO){
		
		
		log.info("INICIA EL SERVICIO comprarComic ...");
		
		ComicDTO comicDTO = new ComicDTO();
		
		try {
			comicDTO = this.iGestionarCompraComicLocal.comprarComic(cantidadCompra, comicAComprarDTO);
			 
			comicDTO.setExitoso(true);
			comicDTO.setMensajeEjecucion("La compra del comic " + comicDTO.getNombre() + " fue exitosa");
			log.info("--Compra realizada con exito--");
			 
		}catch(Exception e) {
			comicDTO.setExitoso(false);
			comicDTO.setMensajeEjecucion("--Se ha producido un error en la transaccion, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la transaccion, error de tipo: " + e.getMessage() + "--");
			
		}
		
		log.info("FINALIZA EL SERVICIO consultarNombrePrecio ...");
		return comicDTO;
	}
}

