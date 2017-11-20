package marketplace.interfaz;


public interface IAutenticacion {
	boolean autenticar(String username, String passwordEncriptado, String password);
}  