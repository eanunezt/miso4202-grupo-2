package marketplace.dao;

import marketplace.modelo.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author eanunezt
  */
@Stateless
public class ProductoDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Producto> obtenerTodos(){
		return em.createNamedQuery("Producto.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Producto obtener(Long id){
		return em.find(Producto.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Producto guardar(Producto entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Producto.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Producto entidad){
		em.merge(entidad);
	}
	
	
}
