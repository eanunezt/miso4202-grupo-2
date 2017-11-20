package marketplace.conf;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import marketplace.interfaz.IAutenticacion;
import marketplace.servicio.CredencialesAutServicio;
import marketplace.servicio.TokenAutServicio;

//@Configuration
public class AutenticacionServicioConfig {
	/**@Bean
	@ConditionalOnProperty(name = "autenticacion.tipo", havingValue = "token", matchIfMissing = true)
	public IAutenticacion tokenAutenticacionServicio(){
		return new TokenAutServicio();
	}

	@Bean
	@ConditionalOnProperty(name = "autenticacion.tipo", havingValue = "credenciales")
	public IAutenticacion credencialesAutenticacionServicio(){
		return new CredencialesAutServicio();
	}*/	
}

