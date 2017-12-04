package marketplace.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  *  @generated
  *  @author eanunezt
  */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="Producto")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Producto.obtenerTodos", query="select e from Producto e")
})
public class Producto implements Serializable{

	@Id
    @Column(name = "id_producto")
    @GeneratedValue(generator = "ProductoGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProductoGen", sequenceName = "Producto_SEQ",allocationSize = 1)
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
    
    //@Column(name = "valor")
    private String valor;
	    //@Column(name = "valor")
    private String urlImagen;
    
    
    /**
    * @generated
    * -1--1-true 
    */
    //@OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    //private List<Compra> compra;
    
    /**
    * @generated
    * 1-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Usuario proveedor;
    
    /**
    * @generated
    * 1-1-false
    */
    @ManyToOne(cascade={},fetch=FetchType.EAGER)
    private Categoria categoria;
    
    /**
    * @generated
    * -1--1-true 
    */
    //@OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    //private List<Oferta> oferta;
    
    
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
    public String getValor() {
        return this.valor;
    }
    
    /**
    * @generated
    */
    public void setValor(String valor) {
        this.valor = valor;
    }
	
	  /**
    * @generated
    */
    public String getUrlImagen() {
        return this.urlImagen;
    }
    
    /**
    * @generated
    */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    
	
	/*public List<Compra> getCompra(){
		if(compra!=null){
			compra=new ArrayList<Compra>(); 
		}
		return this.compra;
	}
	
	public void setCompra(List<Compra> compra){
		this.compra=compra;
	}*/
	
	/**
	* @generated
	*/
	public Categoria getCategoria() {
	    return this.categoria;
	}
	
	/**
	* @generated
	*/
	public void setCategoria(Categoria categoria) {
	    this.categoria = categoria;
	}
	
	/*public List<Oferta> getOferta(){
		if(oferta!=null){
			oferta=new ArrayList<Oferta>(); 
		}
		return this.oferta;
	}
	
	public void setOferta(List<Oferta> oferta){
		this.oferta=oferta;
	}*/
	
	/**
	* @generated
	*/
	public Usuario getProveedor() {
	    return this.proveedor;
	}
	
	/**
	* @generated
	*/
	public void setProveedor(Usuario proveedor) {
	    this.proveedor = proveedor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto other = (Producto) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
