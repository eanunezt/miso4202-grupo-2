package marketplace.modelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import marketplace.modelo.enums.RolEnum;

/**
  *  @generated
  *  @author eanunezt
  */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="Usuario")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Usuario.obtenerTodos", query="select e from Usuario e")
})
public class Usuario {

	@Id
    //@Column(name = "Usuario_id")
    @GeneratedValue(generator = "UsuarioGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UsuarioGen", sequenceName = "Usuario_SEQ",allocationSize = 1)
	private Long id;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id=id;
	}
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "nombre")
    private String nombre;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "identificacion")
    private Integer identificacion;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "usuario")
    private String usuario;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "password")
    private String password;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "rol")
    private RolEnum rol;
    
    
    /**
    * @generated
    * -1--1-true 
    */
    //@OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    //private List<Producto> catalogo;
    
    
    /**
    * @generated
    */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
    * @generated
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
    * @generated
    */
    public Integer getIdentificacion() {
        return this.identificacion;
    }
    
    /**
    * @generated
    */
    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }
    
    /**
    * @generated
    */
    public String getUsuario() {
        return this.usuario;
    }
    
    /**
    * @generated
    */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
    * @generated
    */
    public String getPassword() {
        return this.password;
    }
    
    /**
    * @generated
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
    * @generated
    */
    public RolEnum getRol() {
        return this.rol;
    }
    
    /**
    * @generated
    */
    public void setRol(RolEnum rol) {
        this.rol = rol;
    }
    
	
	/*public List<Producto> getCatalogo(){
		if(catalogo!=null){
			catalogo=new ArrayList<Producto>(); 
		}
		return this.catalogo;
	}
	
	public void setCatalogo(List<Producto> catalogo){
		this.catalogo=catalogo;
	}*/
	
}
