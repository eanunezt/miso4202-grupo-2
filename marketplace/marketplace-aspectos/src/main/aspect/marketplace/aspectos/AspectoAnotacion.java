package marketplace.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;

@Aspect
public class AspectoAnotacion {

	@Pointcut("execution(* guardar(..))")
	public void puntoCorte() {
	}

	@Before("puntoCorte()")
	public void antesPunto(JoinPoint joinPoint) {
		System.out.println("Advice antes de método guardar");
	}

	@After("puntoCorte()")
	public void despuesPunto(JoinPoint joinPoint) {
		System.out.println("Advice después de métdo guardar");
	}
}
