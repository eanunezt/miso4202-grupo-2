package marketplace.conf;

public class Respuesta {
	String nomProducto;
	String descripcion;
	String contexto;
	String pagoPSE;
	
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getContexto() {
		return contexto;
	}
	public void setContexto(String contexto) {
		this.contexto = contexto;
	}
	public String getPagoPSE() {
		return pagoPSE;
	}
	public void setPagoPSE(String pagoPSE) {
		this.pagoPSE = pagoPSE;
	}
}