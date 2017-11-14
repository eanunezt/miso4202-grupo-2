package marketplace.servicio;

import org.springframework.stereotype.Service;

import marketplace.interfaz.IAutenticacion;

@Service
public class TokenAutServicio implements IAutenticacion{

	@Override
	public void autenticar() {
		System.out.println("Autenticando con Token");
	}

}
