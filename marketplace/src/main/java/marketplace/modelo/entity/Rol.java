package marketplace.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import marketplace.modelo.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
  *  @generated
  *  @author eanunezt
  */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="Rol")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Rol.obtenerTodos", query="select e from Rol e")
})
public class Rol {

	@Id
    //@Column(name = "Rol_id")
    @GeneratedValue(generator = "RolGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RolGen", sequenceName = "Rol_SEQ",allocationSize = 1)
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
    * -1--1-true 
    */
    //@OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    //private List<Usuario> usuario;
    
    
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
    
	
	/*public List<Usuario> getUsuario(){
		if(usuario!=null){
			usuario=new ArrayList<Usuario>(); 
		}
		return this.usuario;
	}
	
	public void setUsuario(List<Usuario> usuario){
		this.usuario=usuario;
	}*/
	
}
