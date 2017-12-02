package marketplace.conf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import marketplace.anotations.IMetodoAutenticacion;
import marketplace.constantes.IConstantesAutenticacion;
import marketplace.modelo.entity.Usuario;
import marketplace.servicio.CredencialesAutServicio;
import marketplace.servicio.TokenAutServicio;

public class MetodoAutenticacion {
	Object clase;
	String tipoAutenticacion;

	public boolean autenticar(Object clase, Usuario usuario, String password){
		boolean anotacionEncontrada = false;
		final Field[] variables = clase.getClass().getDeclaredFields();
		Autenticacion autenticacion = null;
		for (final Field variable : variables) {
			final Annotation anotacionObtenida = variable.getAnnotation(IMetodoAutenticacion.class);
			if (anotacionObtenida != null && anotacionObtenida instanceof IMetodoAutenticacion) {
				anotacionEncontrada = true;
			}
		}

		if(anotacionEncontrada){
			tipoAutenticacion = Propiedades.leerPropiedad(IConstantesAutenticacion.TIPO_AUTENTICACION);
			if(tipoAutenticacion != null && tipoAutenticacion.equals("token")){
				autenticacion  = new Autenticacion(new TokenAutServicio());
			}else{
				autenticacion  = new Autenticacion(new CredencialesAutServicio());
			}
		}
		return autenticacion.ejecutar(usuario.getUsuario(), usuario.getPassword(), password);
	}

}
