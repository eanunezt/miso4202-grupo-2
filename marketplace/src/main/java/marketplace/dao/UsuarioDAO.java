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
public class UsuarioDAO {
	@PersistenceContext
    private EntityManager em;

	
	/**
	* @generated
	*/
	public List<Usuario> obtenerTodos(){
		return em.createNamedQuery("Usuario.obtenerTodos").getResultList();
	}
	
	/**
	* @generated
	*/
	public Usuario obtener(Long id){
		return em.find(Usuario.class, id);
	}
	
	
	/**
	* @generated
	*/
	public Usuario guardar(Usuario entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Usuario.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Usuario entidad){
		em.merge(entidad);
	}
	
	
}
