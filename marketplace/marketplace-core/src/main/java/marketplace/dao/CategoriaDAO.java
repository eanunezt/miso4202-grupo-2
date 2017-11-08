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
	* retorna una lista con los Categoria que se encuentran en la base de datos
	* @return retorna una lista de Categoria
	* @generated
	*/
	public List<Categoria> obtenerTodos(Integer startPosition,Integer maxResult){
	
	TypedQuery<Categoria> findAllQuery = em
					.createQuery(
							"SELECT DISTINCT o FROM Categoria o ORDER BY o.id",
							Categoria.class);
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
