package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultarComicsDTO;
import com.hbt.semillero.dto.ConsultarNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:</b> Clase que determina la creacion de los servicios que vayamos a utilizar para gestionar el comic
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
@Path("/gestionarComic")
public class GestionarComicRest {
	
	/**
	 * --------------------------Implementacion de la capa de negocio (EJB)-------------------------------------------
	 */
	
	/**
	 * Con esa etiqueta puedo acceder a la lógica que contiene ese EJB
	 */
	@EJB
	private IGestionarComicLocal iGestionarComicLocal;
	
	/**
	 * Se crea el atributo log para poder utilizarlo, util para los mensajes en la consola a medida que realizamos debug
	 */
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
	
	/**
	 * 
	 * Constructor vacio de la clase.
	 */
	public GestionarComicRest() {
		//Constructor vacío, se inicial el funcionamiento del REST
		BasicConfigurator.configure();
	}
	
	/**
	 * 
	 * Metodo encargado de definir el servicio consultarNombrePrecio, el cual consulta los valores de nombre y precio de un Comic
	 * OJO: Se recomienda el uso de log para monitorear el estado del servicio
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param idComic
	 * @return
	 */
	@GET //Es una consulta
	@Path("/consultarNombrePrecioComic") //Siempre es el nombre que se le da al servicio
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic){ //QueryParam contiene el nombre del parámetro que voy a enviar
		
		log.info("INICIA EL SERVICIO consultarNombrePrecio ...");
		
		ConsultarNombrePrecioComicDTO consulta = new ConsultarNombrePrecioComicDTO();
		
		try {
			 consulta = this.iGestionarComicLocal.consultarNombrePrecioComic(idComic);
			 
			 consulta.setExitoso(true);
			 consulta.setMensajeEjecucion("--Consulta realizada con exito--"); //Establecemos el mensaje de resultado de la consulta
			 log.info("--Consulta realizada con exito--"); //Lanzamos un mensaje al log para monitorear la consulta
			 
		}catch(Exception e) {
			consulta.setExitoso(false);
			consulta.setMensajeEjecucion("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
			
		}
		
		log.info("FINALIZA EL SERVICIO consultarNombrePrecio ...");
		
		return consulta;
		
	}
	
	/**
	 * 
	 * Metodo encargado de definir el servicio que nos permite crear un nuevo Comic
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comicDTO
	 * @return
	 */
	@POST //Haremos una transacción
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		
		log.info("INICIA EL SERVICIO crearComic ...");
		
		ComicDTO transaccionComicDTO = new ComicDTO();
		
		try {
			transaccionComicDTO = this.iGestionarComicLocal.crearComic(comicDTO);
			
			transaccionComicDTO.setExitoso(true);
			transaccionComicDTO.setMensajeEjecucion("--Creacion realizada con exito--"); 
			log.info("--Creacion realizada con exito--"); //Lanzamos un mensaje al log para monitorear la consulta
			
		}catch(Exception e) {
			transaccionComicDTO.setExitoso(false);
			transaccionComicDTO.setMensajeEjecucion("--Se ha producido un error en la creacion del registro, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la creacion del registro, error de tipo: " + e.getMessage() + "--");
			
		}
		
		log.info("FINALIZA EL SERVICIO crearComic ...");
		
		return transaccionComicDTO; //Este DTO será convertido a JSON para que POSTMAN entienda esta información
	}
	
	/**
	 * 
	 * Metodo encargado de realizar la actualización de un registro en la tabla COMIC
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param idComic
	 * @param comicDTO
	 * @return 
	 */
	@POST
	@Path("/actualizarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO actualizarComic(@QueryParam("idComic") Long idComic, ComicDTO comicDTO) {
		
		log.info("INICIA EL SERVICIO actualizarComic ...");
		
		ComicDTO actualizacionComicDTO = new ComicDTO();
		
		try {
			actualizacionComicDTO = this.iGestionarComicLocal.actualizarComic(idComic, comicDTO);
			
			actualizacionComicDTO.setExitoso(true);
			actualizacionComicDTO.setMensajeEjecucion("--Actualizacion realizada con exito--");
			log.info("--Actualizacion realizada con exito--");
			
		}catch(Exception e) {
			actualizacionComicDTO.setExitoso(false);
			actualizacionComicDTO.setMensajeEjecucion("--Se ha producido un error en la actualizacion, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la actualizacion, error de tipo: " + e.getMessage() + "--");
			
		}
		
		return actualizacionComicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de realizar la eliminación de un registro dentro de la tabla COMIC 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param idComic
	 * @return
	 */
	@POST
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic) {
		
		log.info("INICIA EL SERVICIO eliminarComic ...");
		
		ResultadoDTO resultadoEliminarComic = new ResultadoDTO();
		
		try {
			resultadoEliminarComic = this.iGestionarComicLocal.eliminarComic(idComic);
			
			resultadoEliminarComic.setExitoso(true);
			resultadoEliminarComic.setMensajeEjecucion("--Eliminacion realizada con exito--");
			log.info("--Eliminacion realizada con exito--");
			
		}catch(Exception e) {
			resultadoEliminarComic.setExitoso(false);
			resultadoEliminarComic.setMensajeEjecucion("--Se ha producido un error en la eliminacion, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la eliminacion, error de tipo: " + e.getMessage() + "--");
			
		}
		
		return resultadoEliminarComic;
	}
	
	/**
	 * 
	 * Metodo encargado de realizar la consulta de todos los registros dentro de la tabla COMIC
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return
	 */
	@GET //Es una consulta
	@Path("/consultarComics") //Siempre es el nombre que se le da al servicio
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarComicsDTO consultarComics(){
		
		log.info("INICIA EL SERVICIO consultarComics ...");
		
		ConsultarComicsDTO consultarComicsDTO = new ConsultarComicsDTO();
		
		try {
			consultarComicsDTO = this.iGestionarComicLocal.consultarComics();
			
			consultarComicsDTO.setExitoso(true);
			consultarComicsDTO.setMensajeEjecucion("--Consulta realizada con exito--");
			log.info("--Consulta realizada con exito--");
			
		}catch(Exception e) {
			consultarComicsDTO.setExitoso(false);
			consultarComicsDTO.setMensajeEjecucion("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
			
		}
		
		return consultarComicsDTO;		
	}
	
	/**
	 * 
	 * Metodo encargado de consultar que Comics sobrepasan la longitud en sus nombres dada por el usuario y cuales otros no
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param lenghtComic
	 * @return
	 */
	@GET //Es una consulta
	@Path("/consultarComicTamanioNombre") //Siempre es el nombre que se le da al servicio
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(@QueryParam("lenghtComic") Short lenghtComic) {
		
		log.info("INICIA EL SERVICIO consultarComicTamanioNombre ...");
		ConsultarComicTamanioNombreDTO consultarComicTamanioNombre = new ConsultarComicTamanioNombreDTO();
		
		//Como condición fundamental, la longitud entregada por el usuario debe ser positiva
		if(lenghtComic < 0) {
			consultarComicTamanioNombre.setExitoso(false);
			consultarComicTamanioNombre.setMensajeEjecucion("--Se ha producido un error en la consulta, error de tipo: Debe escoger un numero positivo para la longitud del nombre--");
			log.info("--Se ha producido un error en la consulta, error de tipo: Debe escoger un numero positivo para la longitud del nombre--");
			
			return consultarComicTamanioNombre;
		}
		
		try {
			consultarComicTamanioNombre = this.iGestionarComicLocal.consultarComicTamanioNombre(lenghtComic);
				
			consultarComicTamanioNombre.setExitoso(true);
			consultarComicTamanioNombre.setMensajeEjecucion("--Consulta realizada con exito--");
			log.info("--Consulta realizada con exito--");
				
		}catch(Exception e) {
			consultarComicTamanioNombre.setExitoso(false);
			consultarComicTamanioNombre.setMensajeEjecucion("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
			log.info("--Se ha producido un error en la consulta, error de tipo: " + e.getMessage() + "--");
		}
			
		return consultarComicTamanioNombre;
	}
	
}
