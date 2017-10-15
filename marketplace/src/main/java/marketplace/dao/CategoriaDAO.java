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
public class CategoriaDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Categoria> obtenerTodos(){
		return em.createNamedQuery("Categoria.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Categoria obtener(Long id){
		return em.find(Categoria.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Categoria guardar(Categoria entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Categoria.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Categoria entidad){
		em.merge(entidad);
	}
	
	
}
