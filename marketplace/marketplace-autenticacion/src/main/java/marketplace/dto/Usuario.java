package marketplace.dto;

import marketplace.enums.RolEnum;

public class Usuario {
	private Long id;
    private String nombre;
    private Integer identificacion;
    private String usuario;
    private String password;
    private RolEnum rol;
    private String passwd;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RolEnum getRol() {
		return rol;
	}
	public void setRol(RolEnum rol) {
		this.rol = rol;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
