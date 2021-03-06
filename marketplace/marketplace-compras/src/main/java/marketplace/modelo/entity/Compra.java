package marketplace.modelo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@XmlRootElement
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
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id_compra")
    @GeneratedValue(generator = "CompraGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CompraGen", sequenceName = "Compra_SEQ",allocationSize = 1)
	private Long id;
	
	@Column(length = 50)
	@NotNull
	private String descripcion;

	@Column
	@NotNull
	private Double valor;

	@Column
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date fechaCompra;
	
	@OneToMany(targetEntity=Oferta.class,fetch=FetchType.EAGER)
	private Set<marketplace.modelo.entity.Oferta> ofertas = new HashSet<marketplace.modelo.entity.Oferta>();
	
	@OneToMany(targetEntity=Producto.class,fetch=FetchType.EAGER)
	private Set<marketplace.modelo.entity.Producto> productos = new HashSet<marketplace.modelo.entity.Producto>();

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Compra)) {
			return false;
		}
		Compra other = (Compra) obj;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		if (descripcion != null && !descripcion.trim().isEmpty())
			result += ", descripcion: " + descripcion;
		if (valor != null)
			result += ", valor: " + valor;
		if (fechaCompra != null)
			result += ", fechaCompra: " + fechaCompra;
		return result;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(final Set<Producto> productos) {
		this.productos = productos;
	}

	public Set<Oferta> getOfertas() {
		return this.ofertas;
	}

	public void setOfertas(final Set<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}