//package semillero.pruebasUnitarias;
//
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import junit.framework.Assert;
//
//
///**
// * 
// * <b>Descripción:</b> Clase que creamos para crear pruebas unitarias y aprender de ellas
// * <b>Caso de Uso:</b> -
// * @author Ángel Gómez
// * @version 1
// */
//public class OperacionesAritmeticasTest {
//	
//	/**
//	 * Se crea el atributo log para poder utilizarlo, util para los mensajes en la consola a medida que realizamos las pruebas unitarias
//	 */
//	private final static Logger log = Logger.getLogger(OperacionesAritmeticasTest.class);
//			
//	
//	@BeforeTest
//	/**
//	 * 
//	 * Metodo encargado de realizar las configuraciones iniciales del Log, necesario para su funcionamiento, además de poner un encabezado
//	 * <b>Caso de Uso</b>-
//	 * @author Ángel Gómez
//	 *
//	 */
//	public void init() {
//		BasicConfigurator.configure();
//		log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
//	}
//	
//	@Test
//	/**
//	 * 
//	 * Metodo encargado de validar el resultado de una suma que se debe realizar de forma exitosa
//	 * <b>Caso de Uso</b>-
//	 * @author Ángel Gómez
//	 *
//	 */
//	public void validarResultadoSumaExitoso() {
//		log.info("Inicia ejecucion del metodo validarResultadoSumaExitoso()");
//		
//		int numero1 = 300;
//		int numero2 = 150;
//		int resultado = 450;
//
//		/*
//		Assert.assertFalse(condition);
//		Assert.assertTrue(condition);
//		Assert.assertEquals(expected, actual);
//		Assert.assertNotNull(object);
//		Assert.assertNull(object);
//		Assert.assertEquals(resultado, numero1 + numero2);
//		*/
//		
//		log.info("Finaliza la ejecucion del metodo validarResultadoSumaExitoso()");
//	}
//	
//	@Test
//	/**
//	 * 
//	 * Metodo encargado de validar el resultado de una suma que se debe realizar de forma incorrecta, esperamos dicho valor erroneo
//	 * <b>Caso de Uso</b> -
//	 * @author Ángel Gómez
//	 *
//	 */
//	public void validarResultadoSumaFallido() {
//		log.info("Inicia ejecucion del metodo validarResultadoSumaFallido()");
//		
//		int numero1 = 300;
//		int numero2 = 150;
//		int resultado = 455;
//		
//		try {
//			Assert.assertTrue(resultado != (numero1 + numero2));
//			
//			if(resultado != (numero1 + numero2)) {
//				log.info("Se ha generado un error funcional probando el test validarResultadoSumaFallido()");
//				throw new Exception("La suma ha fallado en el calculo");
//			}
//		} catch (Exception e) {
//			Assert.assertEquals(e.getMessage(), "La suma ha fallado en el calculo");
//		}
//		log.info("Finaliza la ejecucion del metodo validarResultadoSumaFallido()");
//	}
//	
//	@AfterTest
//	/**
//	 * 
//	 * Metodo encargado de cerrar y dar por terminadas las pruebas unitarias
//	 * <b>Caso de Uso</b>
//	 * @author Ángel Gómez
//	 *
//	 */
//	public void finalizaPruebasUnitarias() {
//		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
//	}
//}
