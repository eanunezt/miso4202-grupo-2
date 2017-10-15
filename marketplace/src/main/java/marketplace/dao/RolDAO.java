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
public class RolDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Rol> obtenerTodos(){
		return em.createNamedQuery("Rol.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Rol obtener(Long id){
		return em.find(Rol.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Rol guardar(Rol entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Rol.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Rol entidad){
		em.merge(entidad);
	}
	
	
}
