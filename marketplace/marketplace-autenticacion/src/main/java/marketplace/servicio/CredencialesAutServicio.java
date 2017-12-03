package marketplace.servicio;

import marketplace.interfaz.IAutenticacion;

public class CredencialesAutServicio implements IAutenticacion{
	@Override
	public boolean autenticar(String username, String passwordEncriptado, String password) {
		System.out.println("La autenticación por credenciales, aun no ha sido implementada");
		return false;
	}

}
