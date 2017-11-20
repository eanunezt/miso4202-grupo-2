package marketplace.conf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import marketplace.anotations.IMetodoAutenticacion;
import marketplace.interfaz.IAutenticacion;
import marketplace.modelo.entity.Usuario;
import marketplace.servicio.CredencialesAutServicio;
import marketplace.servicio.TokenAutServicio;

public class MetodoAutenticacion {
	Object clase;
	String tipoAutenticacion;

	public void autenticar(Object clase, Usuario usuario, String password){
		final Field[] variables = clase.getClass().getDeclaredFields();
		Autenticacion autenticacion;
		for (final Field variable : variables) {
			final Annotation anotacionObtenida = variable.getAnnotation(IMetodoAutenticacion.class);
			if (anotacionObtenida != null && anotacionObtenida instanceof IMetodoAutenticacion) {
				final IMetodoAutenticacion metodo = (IMetodoAutenticacion) anotacionObtenida;
				tipoAutenticacion = metodo.tipoAutenticacion();
			}
		}
		if(tipoAutenticacion != null && tipoAutenticacion == "token"){
			autenticacion  = new Autenticacion(new TokenAutServicio());
		}else{
			autenticacion  = new Autenticacion(new CredencialesAutServicio());
		}
		autenticacion.ejecutar(usuario.getNombre(), usuario.getPassword(), password);
	}

}
