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
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	public List<Usuario> obtenerTodos(Integer startPosition,Integer maxResult){
	
	TypedQuery<Usuario> findAllQuery = em
					.createQuery(
							"SELECT DISTINCT o FROM Usuario o ORDER BY o.id",
							Usuario.class);
			if (startPosition != null) {
				findAllQuery.setFirstResult(startPosition);
			}
			if (maxResult != null) {
				findAllQuery.setMaxResults(maxResult);
			}
			//final List<Oferta> results = findAllQuery.getResultList();
		return findAllQuery.getResultList();
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
