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
	* retorna una lista con los Producto que se encuentran en la base de datos
	* @return retorna una lista de Producto
	* @generated
	*/
	public List<Producto> obtenerTodos(Integer startPosition,Integer maxResult){
	
	TypedQuery<Producto> findAllQuery = em
					.createQuery(
							"SELECT DISTINCT o FROM Producto o ORDER BY o.id",
							Producto.class);
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
