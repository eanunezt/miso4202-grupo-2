package marketplace.modelo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlRootElement;

/**
  *  @generated
  *  @author eanunezt
  */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@Entity
@Table(name="Categoria")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Categoria.obtenerTodos", query="select e from Categoria e")
})
public class Categoria implements Serializable {

	@Id
    //@Column(name = "Categoria_id")
    @GeneratedValue(generator = "CategoriaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CategoriaGen", sequenceName = "Categoria_SEQ",allocationSize = 1)
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
    //private List<Producto> producto;
    
    
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
    
	
	/*public List<Producto> getProducto(){
		if(producto!=null){
			producto=new ArrayList<Producto>(); 
		}
		return this.producto;
	}
	
	public void setProducto(List<Producto> producto){
		this.producto=producto;
	}*/
	
}
