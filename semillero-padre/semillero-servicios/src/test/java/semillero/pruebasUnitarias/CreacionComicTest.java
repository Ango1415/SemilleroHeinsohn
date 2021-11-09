package semillero.pruebasUnitarias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase para realizar pruebas unitarias de las clases ComicDTO y Comic
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author Ángel Gómez
 * @version 1
 */
public class CreacionComicTest {
	
	/**
	 * Se crea el atributo log para poder utilizarlo, util para los mensajes en la consola a medida que realizamos las pruebas unitarias
	 */
	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	
	@BeforeTest
	/**
	 * 
	 * Metodo encargado de realizar las configuraciones iniciales del Log, necesario para su funcionamiento, además de poner un encabezado
	 * <b>Caso de Uso</b>-
	 * @author Ángel Gómez
	 *
	 */
	public void init() {
		BasicConfigurator.configure();
		log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS COMICS :::::::::::::::::::::::::::: ");
	}
	
	@Test
	/**
	 * 
	 * Metodo encargado de validar que la creación de uno o varios comics se realizan de forma exitosa
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author Ángel Gómez
	 *
	 */
	public void validarCreacionComic() {
		log.info("Inicia ejecucion del metodo validarCreacionComic()");
		
//		Assert.assertFalse(condition);
//		Assert.assertTrue(condition);
//		Assert.assertEquals(expected, actual);
//		Assert.assertNotNull(object);
//		Assert.assertNull(object);
		
		ArrayList<ComicDTO> listaComics = new ArrayList<ComicDTO>();

		//ComicDTO Comic1 = new ComicDTO("01", "Superman", "DC", TematicaEnum.AVENTURAS, "Nueva", Integer.valueOf(100), BigDecimal.valueOf(50000), "Jerry Siegel", true, EstadoEnum.ACTIVO, Long.valueOf(20L));
		listaComics.add(new ComicDTO(0L, "Superman", "DC", TematicaEnum.AVENTURAS, "Nueva", Integer.valueOf(100), BigDecimal.valueOf(5000), "Jerry Siegel", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(100)));
		listaComics.add(new ComicDTO(1L, "Superman", "DC", TematicaEnum.AVENTURAS, "Nueva", Integer.valueOf(100), BigDecimal.valueOf(5000), "Jerry Siegel", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(200)));
		listaComics.add(new ComicDTO(2L, "Batman", "DC", TematicaEnum.BELICO, "Nueva", Integer.valueOf(110), BigDecimal.valueOf(5100), "Pedro", false, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(300)));
		listaComics.add(new ComicDTO(3L, "Aquaman", "DC", TematicaEnum.HUMORISTICO, "Nueva", Integer.valueOf(120), BigDecimal.valueOf(5200), "Pablo", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(400)));
		listaComics.add(new ComicDTO(4L, "Aquaman", "DC", TematicaEnum.HUMORISTICO, "Nueva", Integer.valueOf(120), BigDecimal.valueOf(5200), "Pablo", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(500)));
		listaComics.add(new ComicDTO(5L, "WonderWoman", "DC", TematicaEnum.DEPORTIVO, "Nueva", Integer.valueOf(130), BigDecimal.valueOf(5300), "Lucas", false, LocalDate.now(), EstadoEnum.INACTIVO, Integer.valueOf(600)));
		listaComics.add(new ComicDTO(6L, "Flash", "DC", TematicaEnum.FANTASTICO, "Nueva", Integer.valueOf(140), BigDecimal.valueOf(5400), "Henry", false, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(700)));
		listaComics.add(new ComicDTO(7L, "Iron Man", "Marvel", TematicaEnum.CIENCIA_FICCION, "Nueva", Integer.valueOf(150), BigDecimal.valueOf(5500), "Ana", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(800)));
		listaComics.add(new ComicDTO(8L, "Cap America", "Marvel", TematicaEnum.HISTORICO, "Nueva", Integer.valueOf(160), BigDecimal.valueOf(5600), "Teresa", false, LocalDate.now(), EstadoEnum.INACTIVO, Integer.valueOf(100)));
		listaComics.add(new ComicDTO(9L, "Hulk", "Marvel", TematicaEnum.HORROR, "Nueva", Integer.valueOf(170), BigDecimal.valueOf(5700), "Elvira", false, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(200)));
		listaComics.add(new ComicDTO(10L, "Thor", "Marvel", TematicaEnum.AVENTURAS, "Nueva", Integer.valueOf(180), BigDecimal.valueOf(5800), "Julieta", true, LocalDate.now(), EstadoEnum.ACTIVO, Integer.valueOf(300)));
		listaComics.add(new ComicDTO(11L, "Viuda Negra", "Marvel", TematicaEnum.BELICO, "Nueva", Integer.valueOf(190), BigDecimal.valueOf(5900), "Maradona", false, LocalDate.now(), EstadoEnum.INACTIVO, Integer.valueOf(400)));
		
		try {
			
			verificarComicsActivos(listaComics);
			verificarComicsInactivos(listaComics);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
				
		
		log.info("Finaliza la ejecucion del metodo validarCreacionComic()");
	}
	
	@Test	
	/**
	 * 
	 * Metodo encargado de retornar los comics que están activos 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author Angel Gomez
	 * 
	 * @param listaComics Lista de comics para revisar su estado
	 * @return comicsActivos Lista de comics activos de listaComics
	 */
	private ArrayList<ComicDTO> verificarComicsActivos(ArrayList<ComicDTO> listaComics){
		
		log.info("Inicia ejecucion del metodo verificarComicsActivos()");
		ArrayList<ComicDTO> comicsActivos = new ArrayList<ComicDTO>();
		
		for (ComicDTO comic: listaComics) {
			if(comic.getEstadoEnum().equals(EstadoEnum.ACTIVO)) { //Comparamos con el enumerador
				Assert.assertEquals(comic.getEstadoEnum(), EstadoEnum.ACTIVO); //Prueba unitaria para verificar los comics activos
				System.out.println(comic.toString() + "\n"); //Imprimimos los datos del comic
				comicsActivos.add(comic); //Añadimos a la lista de comics activos
			}
		}
		
		log.info("Termina ejecucion del metodo verificarComicsActivos()");
		return comicsActivos;
	}
	
	
	@Test
	/**
	 * 
	 * Metodo encargado de retornar los comics que están inactivos 
	 * <b>Caso de Uso</b>SEMILLERO 2021
	 * @author Angel Gomez
	 * 
	 * @param listaComics Lista de comics para revisar su estado
	 * @return comicsActivos Lista de comics inactivos de listaComics
	 * @throws Exception 
	 */
	private ArrayList<ComicDTO> verificarComicsInactivos(ArrayList<ComicDTO> listaComics) throws Exception{
		
		log.info("Inicia ejecucion del metodo verificarComicsInactivos()");
		
		ArrayList<ComicDTO> comicsInactivos = new ArrayList<ComicDTO>();
		ArrayList<String> nombComicsInactivos = new ArrayList<String>();
		
		for (ComicDTO comic: listaComics) {
			if(comic.getEstadoEnum().equals(EstadoEnum.INACTIVO)) { //Comparamos con el enumerador				
				Assert.assertEquals(comic.getEstadoEnum(), EstadoEnum.INACTIVO); //Prueba unitaria para verificar los comics Inactivos
				comicsInactivos.add(comic); //Añadimos a la lista de inactivos
				nombComicsInactivos.add(comic.getNombre()); //Añadimos a la lista de nombres de comics inactivos
			}
		}
		
		//Use estas var para usar la misma linea de código que usted nos propuso, yo hubiese llamado todo desde el String message
		int tamanioListaTotal = listaComics.size();
		int numeroTotalActivos = listaComics.size() - comicsInactivos.size();
		int numeroTotalInactivos = comicsInactivos.size();
		String nombresComicsInactivos = nombComicsInactivos.toString();
		
		String message = "Se ha detectado que de " + tamanioListaTotal + " comics se encontraron que " + numeroTotalActivos + "  se encuentran activos y " + numeroTotalInactivos + " inactivos. Los comics inactivos son: " + nombresComicsInactivos;
		System.out.println(message); //A pesar de que no se lance la excepción, imprimo el mismo mensaje en consola
		
		//Ingeniero, no entendí bien lo de la excepción del punto 5, la lanzo acá para verificar si se coló algún comic activo
		for (ComicDTO comic: comicsInactivos) {
			if(comic.getEstadoEnum().equals(EstadoEnum.ACTIVO)) { //Comparamos con el enumerador				
				throw new Exception(message);
			}
		}
		
		log.info("Termina ejecucion del metodo verificarComicsInactivos()");
		
		return comicsInactivos;
	}
	
	@AfterTest
	/**
	 * 
	 * Metodo encargado de cerrar y dar por terminadas las pruebas unitarias
	 * <b>Caso de Uso</b>
	 * @author Ángel Gómez
	 *
	 */
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS COMICS :::::::::::::::::::::::::::: ");
	}

}