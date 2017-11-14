package marketplace.modelo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="Oferta")//, schema="${schema}")
@NamedQueries({
	@NamedQuery(name="Oferta.obtenerTodos", query="select e from Oferta e")
})
public class Oferta implements Serializable{

	@Id
    @Column(name = "id_oferta")
    @GeneratedValue(generator = "OfertaGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "OfertaGen", sequenceName = "Oferta_SEQ",allocationSize = 1)
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
    private Integer valor;
    
    
       
    /**
    * @generated
    * 1--1-true 
    */
    @ManyToOne
	private Producto producto;
    
    
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
    public Integer getValor() {
        return this.valor;
    }
    
    /**
    * @generated
    */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
	
	public Producto getProducto(){
		/*if(producto!=null){
			producto=new ArrayList<Producto>(); 
		}*/
		return this.producto;
	}
	
	public void setProducto(Producto producto){
		this.producto=producto;
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Oferta)) {
			return false;
		}
		Oferta other = (Oferta) obj;
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
