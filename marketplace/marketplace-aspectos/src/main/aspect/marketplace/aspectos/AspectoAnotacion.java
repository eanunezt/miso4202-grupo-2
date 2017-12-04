package marketplace.aspectos;

import java.util.Calendar;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;

import marketplace.logger.factoryMethod.creador.CreatorConcretoLogger;
import marketplace.logger.factoryMethod.producto.ILogger;
import marketplace.logger.factoryMethod.producto.Propiedades;


@Aspect
public class AspectoAnotacion {

	@Pointcut("execution(* guardar(..))")
	public void puntoCorte() {
	}

	@Before("puntoCorte()")
	public void antesPunto(JoinPoint joinPoint) {
		//System.out.println("Advice antes de método guardar");
	}

	@After("puntoCorte()")
	public void despuesPunto(JoinPoint joinPoint) {
		String nombreClase = joinPoint.getSignature().toString();
		if(nombreClase.contains("marketplace.servicio.UsuarioServicio.guardar")) {
			//imprimirParametros(joinPoint);
			System.out.println("Se guardo un Usuario");
			String logger = Propiedades.leerPropiedad("logger");
			ILogger l=new CreatorConcretoLogger().logger(logger);
			if(l!=null) l.escribir("Se grabo un usuario "+Calendar.getInstance().getTime().toString());
		}		
	}
}
