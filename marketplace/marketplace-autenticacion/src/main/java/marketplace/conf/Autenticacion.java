package marketplace.conf;

import marketplace.interfaz.IAutenticacion;

public class Autenticacion {
	private IAutenticacion autenticacion;

	public Autenticacion(IAutenticacion autenticacion) {
		this.autenticacion = autenticacion;
	}
	
	public boolean ejecutar(String username, String passwordEncriptado, String password){
		return autenticacion.autenticar(username, passwordEncriptado, password);
	}
}
