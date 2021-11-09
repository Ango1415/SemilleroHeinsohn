package com.hbt.semillero.rest;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.entidad.Comic;


/**
 * 
 * <b>Descripción:</b> Clase que permite realizar transacciones de tipo JPQL entre nuestras clases y la BD
 * <b>Caso de Uso:</b> SEMILLERO 2021
 * @author ANGEL GOMEZ
 * @version 1.0
 */
@Path("/semilleroJPQLRest")
@Stateless //Arquitectura basada en servicios, sin estados
@TransactionManagement(TransactionManagementType.CONTAINER) //CONTAINER gestiona automática el commit y el rollback, el otro modo es BEAN
public class SemilleroJPQLRest {
	
	//A la declaración de las lineas 45 y 46 se les conoce como realizar la inyección del Entity Manager
	/**
	 * Atributo que gestiona la conexión con la BD para hacer transacciones
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Se crea el atributo log para poder utilizarlo, util para los mensajes en la consola a medida que realizamos debug
	 */
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
	
	/**
	 * 
	 * Metodo de ejemplo para entender algunos métodos del Entity Manager 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return 
	 */
	@GET
	@Path("/test2") //Ejecuta el servicio llamado Test desde POSTMAN
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		
		//em.clear(); //Limpia la cache del EM para evitar errores, ya casi no se usa
		//em.close(); //Cerrar la conexión de forma manual, casi no se usa a no ser que lo requieren específicamente
		//em.find(); //Nos permite consultar un registro de una clase mediante su identificador
		//em.flush(); //Sirve para hacer un commit forzado, depende de como este config el servicio
		/**
		 * Los siguientes se usan para volumenes bajos de data a consultar
		 * Con volumenes altos causa problemas de rendimiento
		 * (Persistir, actualizar, eliminar)
		 */
		//em.merge(null); //Sirve para hacer una actualización, lo podemos hacer mediante un Query o con este método
		//em.persist(em); //Esta es la forma en que nosotros hacemos una inserción, enviamos un objeto
		//em.refresh(em); //Obtiene la actualización de un registro
		
		return "Error";
	}
	
	/**
	 * 
	 * Metodo encargado de obtener un comic usando el método find() del Entity Manager
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author ANGEL GOMEZ
	 * 
	 * @return
	 */
	
	

	//Si necesitamos hacer una transaccion es mejor usar el tipo POST, si solamente quiero consultar debo usar el GET
	@GET //Informo que haré consultas, pero no quiere decir que no pueda hacer persistencia, lo que cambia es la forma de recibir o enviar parámetros, con el GET  DEBO USAR EL @QUERYPARAM para enviar parametros si es que lo requiero, para un POST no necesitamos un @QueryParam porque el recibe cualquier tipo de objeto en los parametros del método
	@Path("/test") //Es el nombre de mi servicio, se añade a la URL que le pasamos en POSTMAN para poder acceder a él
	@SuppressWarnings("unused")
	@Produces(MediaType.APPLICATION_JSON)
	//  @Transactional //Maneja el tipo de transacción que se está manejando
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) //El tipo de transaccion que vamos a manejar, REQUIERED todo se va a manejar en una unica transacción; REQUIRED_NEW para ejecutar varias transacciones; NOT_SUPPORTED solo permite consultas, no transacciones 
	public String obtenerUnComic() {
		
		BasicConfigurator.configure();
		Comic comic = null;
		
		try {
			
			//PILAS: Como está estructurado el contenedor del proyecto, unicamente se puede hacer una transacción a la vez (Persistir, Actualizar o Eliminar), por eso las demás aparecen comentadas
			//Consultas si se pueden hacer las que quiera
			
			//------------------------CONSULTAS (Read)------------------------------
			
//			/**
//			 * De la siguiente forma obtendremos un solo registro (find one)
//			 * Tenga en cuenta que se deben usar DTO, así como lo tenemos, con la entidad Comic, está mal hecho
//			 * Haremos: SELECT * FROM COMIC WHERE ID = 1 con el metodo find()
//			 */
//			//Siempre el segundo parametro será una llave primaria, y el tipo de dato dependerá de como lo tengamos mapeado en la entidad.
//			comic = em.find(Comic.class, 2L); //El primer parámetro será la clase que tenemos mapeada y el segundo es la PK que será nuestro identificador en la BD, en nuestro ejemplo tomamos el Id 1 que es el de Dagon Ball Yamcha
//			
//			/**
//			 * el find() solo permite hacer consultas por la PK
//			 * Si queremos hacer una consulta por un valor diferente a la PK (nombre, tipo, etc...) debemos hacer un Query, lo veremos a continuacion
//			 * Haremos: SELECT * FROM COMIC WHERE ID = 1 en JPQL usando la clase Query
//			 */
//			//Se realiza con JPQL y usando la clase Query
//			String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = 1 "; //Consulta JPQL
//			Query queryUnComic = em.createQuery(consultaUnComic); //Instanciamos un Query, si la consulta esta bien sintácticamente no genera error
//			
//			/**
//			 * Algunos métodos de Query mas usados
//			 */
//			//queryUnComic.executeUpdate(); //Ejecuta el Query y hace commit para actualizar
//			//queryUnComic.getResultList(); //Obtenemos una lista de nuestra consulta
//			//queryUnComic.getSingleResult(); //Retorna solo un registro
//			//queryUnComic.setFirstResult(0); //Empieza una consulta a partir de un registro
//			//queryUnComic.setMaxResults(0); //De esa consulta trae n registros máximo
//			//queryUnComic.setParameter("idComic", 1L); //Establecemos el valor de un parametro en una consulta
//			
//			Comic comic1 = (Comic) queryUnComic.getSingleResult(); //Extraigo del Query la consulta que deseaba, se requiere hacer un Casteo para converir la consulta en el tipo de dato que queremos obtener, esto solo se hace con getSingleResult
//			
//			
//			/**
//			 * Si queremos hacer una consulta por un valor diferente a la PK (nombre, tipo, etc...) y que la consulta esté parametrizada
//			 * Haremos: SELECT * FROM COMIC WHERE ID = 1 en JPQL usando la clase Query con parametros
//			 */
//			String consultaUnComicConParametro = " SELECT c FROM Comic c WHERE c.id = :idComic ";
//					//+ " AND c.estadoEnum = :estadoComic "
//					//+ " ORDER BY c.nombre DESC ";
//			Query queryUnComicConParametro= em.createQuery(consultaUnComicConParametro);
//			queryUnComicConParametro.setParameter("idComic", 1L); //El primer parametro es el nombre que establecimos para el parametro en la consulta y el segundo será el valor que le asignaremos a dicho parámetro
//			//queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO); 
//			// Si se usan constantes en lugar de variables, en ese caso usaremos enumeradores
//			//queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO); //El primer parametro es el nombre que establecimos para el parametro en la consulta y el segundo será el valor que le asignaremos a dicho parámetro
//			// RECUERDE: Los valores de esos parámetros llegaran de un DTO
//			Comic comic2 = (Comic) queryUnComicConParametro.getSingleResult();
//			
//			
//			/**
//			 * Si queremos hacer una consulta por un valor diferente a la PK (nombre, tipo, etc...) y que nos retorne una lista de resultados
//			 * Haremos: SELECT * FROM COMIC
//			 */
//			String findAllComic = " SELECT cm FROM Comic cm ";
//			Query queryFindAllComic = em.createQuery(findAllComic);
//			List<Comic> listaComics = queryFindAllComic.getResultList();
			
			
			//BLOQUE PARA GENERACION DE EXCEPCIONES
//			/**
//			 * Debemos ser siempre lo más específicos con los errores para poder controlarlos
//			 * Usaremos frecuentemente 2: NotUniqueException (para más de un resultado en getSingleResult())
//			 * NotResultException (no obtenemos ningun resultado en getSingleResult())
//			 */
//			
//			//Lanza un NoResultExceptio
//			String consultaUnComicConeExcepcion = " SELECT c FROM Comic c WHERE c.id = :idComic "
//					+ " AND c.estadoEnum = :estadoComic "
//					+ " ORDER BY c.nombre DESC ";
//			Query queryUnComicConExcepcion= em.createQuery(consultaUnComicConeExcepcion);
//			queryUnComicConExcepcion.setParameter("idComic", 99L); 
//			queryUnComicConExcepcion.setParameter("estadoComic", EstadoEnum.ACTIVO); 
//			Comic comic3 = (Comic) queryUnComicConExcepcion.getSingleResult();
			
			//Lanza un NonUniqueResultException
//			String consultaUnComicConeExcepcion2 = " SELECT c FROM Comic c WHERE c.estadoEnum = :estadoComic ";
//			//		+ " AND c.estadoEnum = :estadoComic "
//			//		+ " ORDER BY c.nombre DESC ";
//			Query queryUnComicConExcepcion2= em.createQuery(consultaUnComicConeExcepcion2);
//			//queryUnComicConExcepcion2.setParameter("idComic", 99L); 
//			queryUnComicConExcepcion2.setParameter("estadoComic", EstadoEnum.ACTIVO); 
//			Comic comic4 = (Comic) queryUnComicConExcepcion2.getSingleResult();
//			
			
			//------------------------PERSISTENCIA(Create)------------------------------
			/**
			 * Se puede realizar mediante una consulta nativa (JPQL o SQL) o mediante el entity manager con el método persist() 
			 * 
			 */
			
//			comic = new Comic();
//			//No ingresamos el identificador porque tenemos mapeada nuestra secuencia en la clase, por lo que él lo generará automáticamente
//			//A la hora de hacer la actualización si debemos usar el identificador
//			comic.setNombre("Superman");
//			comic.setEditorial("DC");
//			comic.setColeccion("Primera Edicion");
//			comic.setNumeroPaginas(100);
//			comic.setPrecio(new BigDecimal(500));
//			comic.setCantidad(3);
			
//			em.persist(comic); //Recibe como parámetro el objeto que queremos grabar, debe ser una entidad mapeada y debe manejar la notación table
			
			//Para probarlo vamos a hacer una consulta
			String consultaNuevoComic = " SELECT c FROM Comic c WHERE c.nombre = :nombreComic ";
			Query queryUnComicNuevo= em.createQuery(consultaNuevoComic);
			queryUnComicNuevo.setParameter("nombreComic", "SUPERMAN_CAMBIA");
			Comic comicNuevo = (Comic) queryUnComicNuevo.getSingleResult();
			
			System.out.println("Pausa");
			
			
//			//------------------------ACTUALIZACIÓN (Update)--------- ---------------------
//			
//			comic.setPrecio(new BigDecimal(600));
//			comic.setCantidad(5);
//			em.merge(comic);
//			Comic comicActualziado2 = this.consultarComicPorNombre();
//			
//			//------------------------ELIMINAR (DELETE)------------------------------
//			
			em.remove(comicNuevo);
			//Comic comicEliminado2 = this.consultarComicPorNombre(); //Debería salir "No se han encontrado registros"
			
			System.out.println("Pausa");
			
			
			//______________________HACIENDO USO DE QUERYS______________________________
			//Estas son muy buenas para volumenes altos de información (ya sea SQL o JPQL)
//			String actualizarComic = " UPDATE Comic c SET c.nombre = :nombre WHERE c.id = :idComic ";
//			Query queryActualizar = em.createQuery(actualizarComic);
//			queryActualizar.setParameter("nombre", "SUPERMAN_CAMBIA");
//			queryActualizar.setParameter("idComic", comic.getId());
//			queryActualizar.executeUpdate(); //Este se usa siempre para eliminación y actualización con Querys JPQL y SQL
//			
//			comic = em.find(Comic.class, comic.getId());
//			
//			String eliminarComic = " DELETE FROM Comic WHERE id = :idComic ";
//			Query queryEliminar = em.createQuery(eliminarComic);
//			queryEliminar.setParameter("estado", EstadoEnum.ACTIVO);
//			queryEliminar.setParameter("idComic", 4L);
//			queryEliminar.executeUpdate(); //Este se usa siempre para eliminación y actualización con Querys JPQL y SQL 
//			
//			List<Long> listaIdComic = new ArrayList<>(); 
//			listaIdComic.add(2L);
//			listaIdComic.add(3L);
//			listaIdComic.add(4L);
//			String actualizarVariosComics = " UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id IN (:listIdComics)";
//			Query queryActualizarVariosComics = em.createQuery(actualizarVariosComics);
//			queryActualizarVariosComics.setParameter("estado", EstadoEnum.ACTIVO);
//			queryActualizarVariosComics.setParameter("listIdComics", listaIdComic);
//			queryActualizarVariosComics.executeUpdate(); //Este se usa siempre para eliminación y actualización con Querys JPQL y SQL
//			
//			String eliminarVariosComics = " DELETE FROM Comic WHERE id = :idComic ";
//			Query queryEliminarVariosComics = em.createQuery(eliminarVariosComics);
//			queryEliminarVariosComics.setParameter("estado", EstadoEnum.ACTIVO);
//			queryEliminarVariosComics.setParameter("idComic", 4L);
//			queryEliminarVariosComics.executeUpdate(); //Este se usa siempre para eliminación y actualización con Querys JPQL y SQL
//			
//			//______________________HACIENDO CONSULTAS NATIVAS______________________________
//			String consulta = " SELECT SCNOMBRE FRORM COMIC WHERE SCID = :idComic";
//			Query consultaNativa = em.createNativeQuery(consulta);
//			consultaNativa.setParameter("idComic", 2L);
//			String nombreComic = (String) consultaNativa.getSingleResult();
//			
//			String consulta2 = " SELECT SCNOMBRE, SCPRECIO FRORM COMIC WHERE SCID = :idComic";
//			Query consultaNativa2 = em.createNativeQuery(consulta2);
//			consultaNativa2.setParameter("idComic", 2L);
//			Object[] data = (Object[]) consultaNativa2.getSingleResult();
//			String nombre = (String)data[0];
//			BigDecimal precio = (BigDecimal)data[1];
			
		}catch(NonUniqueResultException nur) {
			log.info("Existe mas de un registro" + nur.getMessage());
		}catch(NoResultException nre) {
			log.info("No se han encontrado registros con el ID " + 99L + nre.getMessage());
		}catch(Exception e) { //Este es un error más general, diferente de los anteriores
			log.info("Se ha presentado un error tecnico " + e.getMessage());
			return e.getMessage();
		}
		
		
		return "Esto es una prueba";
	}
	
//	private Comic consultarComicPorNombre() {
//		String consultaNuevoComic = " SELECT c FROM Comic c WHERE c.nombre = :nombreComic ";
//		Query queryUnComicNuevo= em.createQuery(consultaNuevoComic);
//		queryUnComicNuevo.setParameter("nombreComic", "Superman");
//		Comic comicNuevo = (Comic) queryUnComicNuevo.getSingleResult();
//		return comicNuevo;
//	}
}

