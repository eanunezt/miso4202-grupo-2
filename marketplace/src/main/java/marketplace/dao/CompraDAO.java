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
public class CompraDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Compra> obtenerTodos(){
		return em.createNamedQuery("Compra.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Compra obtener(Long id){
		return em.find(Compra.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Compra guardar(Compra entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Compra.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Compra entidad){
		em.merge(entidad);
	}
	
	
}
