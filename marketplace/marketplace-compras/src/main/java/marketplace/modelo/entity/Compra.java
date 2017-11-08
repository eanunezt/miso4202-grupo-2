package marketplace.modelo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
  *  @generated
  *  @author eanunezt
  */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="Compra")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Compra.obtenerTodos", query="select e from Compra e")
})
public class Compra {

	@Id
    //@Column(name = "Compra_id")
    @GeneratedValue(generator = "CompraGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CompraGen", sequenceName = "Compra_SEQ",allocationSize = 1)
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
    
    //@Column(name = "descripcion")
    private String descripcion;
    
    /**
    * @generated
    * 1-1-false
    */
    
    //@Column(name = "valor")
    private Integer valor;
    
    
    /**
    * @generated
    * 0--1-true 
    */
    @OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    private List<Producto> producto;
    
    /**
    * @generated
    * 0--1-true 
    */
    @OneToMany(cascade={},fetch=javax.persistence.FetchType.LAZY)
    private List<Oferta> oferta;
    
    
    /**
    * @generated
    */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
    * @generated
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
    * @generated
    */
    public Integer getValor() {
        return this.valor;
    }
    
    /**
    * @generated
    */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
	
	public List<Oferta> getOferta(){
		if(oferta!=null){
			oferta=new ArrayList<Oferta>(); 
		}
		return this.oferta;
	}
	
	public void setOferta(List<Oferta> oferta){
		this.oferta=oferta;
	}
	
	public List<Producto> getProducto(){
		if(producto!=null){
			producto=new ArrayList<Producto>(); 
		}
		return this.producto;
	}
	
	public void setProducto(List<Producto> producto){
		this.producto=producto;
	}
	
}
