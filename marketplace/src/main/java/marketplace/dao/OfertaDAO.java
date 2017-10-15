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
public class OfertaDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Oferta> obtenerTodos(){
		return em.createNamedQuery("Oferta.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Oferta obtener(Long id){
		return em.find(Oferta.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Oferta guardar(Oferta entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Oferta.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Oferta entidad){
		em.merge(entidad);
	}
	
	
}
