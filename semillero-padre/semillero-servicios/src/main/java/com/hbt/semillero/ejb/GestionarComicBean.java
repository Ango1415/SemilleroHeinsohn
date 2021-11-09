package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultarComicsDTO;
import com.hbt.semillero.dto.ConsultarNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;

/**
 * 
 * <b>Descripción:</b> Clase que implementa la interfaz de gestionar comic y agrega la funcionalidad de cada uno de los métodos
 * Contiene toda la lógica de negocio y lo concerniente a la gestión de las transacciones
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal{
	
	/**
	 * Atributo que gestiona la conexión con la BD para hacer transacciones
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarNombrePrecioComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultarNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) throws Exception{

		ConsultarNombrePrecioComicDTO consultarNombrePrecioComicDTO = new ConsultarNombrePrecioComicDTO();
		
		//El ingeniero nos dice que él prefiere que realicemos el control de excepciones en la parte del REST
		
		//FORMA 1: Controlando los errores desde acá, tendriamos que quitar el throws Exception
//		String consulta = " SELECT c.nombre, c.precio FROM Comic c WHERE c.id = :idComic";
//		try {
//			
//			Query consultaNombrePrecio = em.createQuery(consulta);
//			consultaNombrePrecio.setParameter("idComic", idComic);
//			Object[] data = (Object[]) consultaNombrePrecio.getSingleResult();
//			String nombre = (String)data[0];
//			BigDecimal precio = (BigDecimal)data[1];
//			
//			consultarNombrePrecioComicDTO.setNombre(nombre);
//			consultarNombrePrecioComicDTO.setPrecio(precio);
//			consultarNombrePrecioComicDTO.setExitoso(true);
//			consultarNombrePrecioComicDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");
//			
//		}catch(Exception e) {
//			consultarNombrePrecioComicDTO.setExitoso(false);
//			consultarNombrePrecioComicDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
//		}
		
		//FORMA 2: Lanzando desde acá la excepción y controlandola en el rest
//		String consulta = " SELECT c.nombre, c.precio FROM Comic c WHERE c.id = :idComic";
//		Query consultaNombrePrecio = em.createQuery(consulta);
//		consultaNombrePrecio.setParameter("idComic", idComic);
//		Object[] data = (Object[]) consultaNombrePrecio.getSingleResult();
//		String nombre = (String)data[0];
//		BigDecimal precio = (BigDecimal)data[1];
//		
//		consultarNombrePrecioComicDTO.setNombre(nombre);
//		consultarNombrePrecioComicDTO.setPrecio(precio);
		
		//FORMA 3: Modificando la forma de la consulta, dandole valores al DTO desde la misma consulta y reduciendo lineas de código
		String consulta = " SELECT new com.hbt.semillero.dto.ConsultarNombrePrecioComicDTO(c.nombre, c.precio) "
				+ "FROM Comic c WHERE c.id = :idComic";
		Query consultaNombrePrecio = em.createQuery(consulta);
		consultaNombrePrecio.setParameter("idComic", idComic);
		consultarNombrePrecioComicDTO = (ConsultarNombrePrecioComicDTO) consultaNombrePrecio.getSingleResult();
		
		return consultarNombrePrecioComicDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception{
		//Desde POSTMAN enviamos la info para guardarla, un DTO no nos servida para persistir la info con el em, para ello debemos convertirlo a Entidad.
		
		if(comicDTO.getNombre() == null) { //En este caso el nombre es requerido, por eso hacemos este control de Excepciones
			throw new Exception ("El campo nombre es requerido");
		}
		
		Comic comic = this.convertirComicDTOToComic(comicDTO); //Se requiere hacer la conversion porque el DTO no está mapeado y no permite hacer persistencia
		
		em.persist(comic);
		
		ComicDTO comicDTOResult = this.convertirComicToComicDTO(comic); //Tenemos que generar otro DTO para enviarlo al front
		
		return comicDTOResult;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#actualizarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO actualizarComic(Long idComic, ComicDTO comicDTO) throws Exception {
		
		Comic comic = em.find(Comic.class, idComic);
		
		//comic.setId(comicDTO.getId()); //Este no se cambia porque precisamente es el que nos va a permitir hacer el merge sobre el comic que nos interesa
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
		
		em.merge(comic);
		ComicDTO comicResultadoDTO = this.convertirComicToComicDTO(comic);
		
		return comicResultadoDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarComic(Long idComic) throws Exception{
		
		Comic comic = em.find(Comic.class, idComic);
		em.remove(comic);
		
		return new ResultadoDTO();
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicsDTO consultarComics() throws Exception{
		
		ConsultarComicsDTO consultarComicsDTO = new ConsultarComicsDTO();
		
		String findAllComic = " SELECT cm FROM Comic cm ";
		Query queryFindAllComic = em.createQuery(findAllComic);
		List<ComicDTO> listaComics = queryFindAllComic.getResultList();
		
		consultarComicsDTO.setListaComicsDTO(listaComics);
		
		return consultarComicsDTO;
	}
	
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComicTamanioNombre(java.lang.Short)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lenghtComic) throws Exception {
		
		ConsultarComicTamanioNombreDTO consultarComicTamanioNombreDTO = new ConsultarComicTamanioNombreDTO();
		
		List<ComicDTO> listaSuperaLongitud = new ArrayList<>();
		List<ComicDTO> listaNoSuperaLongitud = new ArrayList<>();
		
		//Hago la consulta de todos los comics existentes en la tabla COMIC
		String findAllComic = " SELECT cm FROM Comic cm ";
		Query queryFindAllComic = em.createQuery(findAllComic);
		List<Comic> listaComics = queryFindAllComic.getResultList();
		
		//Discrimino de acuerdo a la longitud del nombre de cada Comic
		ComicDTO comicDTO = new ComicDTO();
		
		for(Comic comic : listaComics) {
			if(comic.getNombre().length() >= lenghtComic) {
				comicDTO = this.convertirComicToComicDTO(comic); //Convierto el comic a dto para luego transferirlo
				listaSuperaLongitud.add(comicDTO);
				
			}else {
				comicDTO = this.convertirComicToComicDTO(comic);
				listaNoSuperaLongitud.add(comicDTO);
				
			}
		}
		
		//Agrego las dos listas al DTO
		consultarComicTamanioNombreDTO.setListaSuperaLongitud(listaSuperaLongitud);
		consultarComicTamanioNombreDTO.setListaNoSuperaLongitud(listaNoSuperaLongitud);
		
		return consultarComicTamanioNombreDTO;
	}
	
	
	//---------------------------Métodos de conversión----------------------------
	/**
	 * 
	 * Metodo encargado de convertir un ComicDTO en una entidad Comic 
	 * <b>Caso de Uso</b> SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @param comic
	 * @return
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
	 * @param comic
	 * @return
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
	
	//----------Ejemplo de Prueba Unitaria para REST y BEAN (Para servicios en general)--------
//	@Test
//	public void crearComicExitoso() {
//		ComicDTO comicDTO = new ComicDTO();
//		comicDTO.setAutores("Pedro Pablo");
//		comicDTO.setCantidad(2L);
//		comicDTO.setColeccion("Marvel");
//		comicDTO.setColor(true);
//		comicDTO.setEditorial("Marvel");
//		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
//		comicDTO.setFechaVenta(LocalDate.now());
//		comicDTO.setNombre("Guardianes de la Galaxia");
//		comicDTO.setNumeroPaginas(120);
//		comicDTO.setPrecio(new BigDecimal(800));
//		comicDTO.setTematicaEnum(TematicaEnum.CIENCIA_FICCION);
//		
//		Assert.assertNotNull(gestionarComicLocal); //Para empezar, si no está implementada esta interfaz no nos servirá ningún servicio
//		try {
//			ComicDTO comicDTOResult = this.gestinarComicLocal.crearComic(comicDTO);
//			Comic comicEntity = em.find(Comic.class, comicDTOResult.getId());
//			
//			Assert.assertEquals(comicEntity.getNombre(), comicDTO.getNombre());
//			Assert.assertEquals(comicEntity.getTematicaEnum(), comicDTO.getTematicaEnum());
//			Assert.assertTrue(comicEntity.getColor());
//			
//		}catch(Exception e) {
//			Assert.fail();
//		}	
//	}
}
