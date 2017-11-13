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
	* retorna una lista con los Compra que se encuentran en la base de datos
	* @return retorna una lista de Compra
	* @generated
	*/
	public List<Compra> obtenerTodos(Integer startPosition,Integer maxResult){
	
	TypedQuery<Compra> findAllQuery = em
					.createQuery(
							"SELECT DISTINCT o FROM Compra o ORDER BY o.id",
							Compra.class);
			if (startPosition != null) {
				findAllQuery.setFirstResult(startPosition);
			}
			if (maxResult != null) {
				findAllQuery.setMaxResults(maxResult);
			}
			final List<Compra> results = findAllQuery.getResultList();
		return results; //findAllQuery.getResultList();
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
