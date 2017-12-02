package marketplace.conf;

import marketplace.modelo.entity.Usuario;

public class Respuesta {
	String producto;
	Usuario usuario;
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
