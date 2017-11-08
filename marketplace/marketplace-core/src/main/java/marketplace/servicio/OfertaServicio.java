package marketplace.servicio;


import marketplace.dao.*;
import marketplace.modelo.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
  *  @generated
  *  @author eanunezt
  */
@Stateless
public class OfertaServicio {
	@EJB
    private OfertaDAO dao;


	
	/**
	* retorna una lista con los Oferta que se encuentran en la base de datos
	* @return retorna una lista de Oferta
	* @generated
	*/
	public List<Oferta> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	
	/**
	* retorna una lista con los Oferta que se encuentran en la base de datos
	* @return retorna una lista de Oferta
	* @generated
	*/
	public List<Oferta> obtenerTodos(Integer startPosition,Integer maxResult){
		return dao.obtenerTodos(startPosition,maxResult);
	}
	
	
	
	/**
	* @param id identificador del elemento Oferta
	* @return Oferta del id dado
	* @generated
	*/
	public Oferta obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Oferta
	 * @param entity Oferta a guardar
	 * @return Oferta con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Oferta guardar(Oferta entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Oferta con el identificador dado
	 * @param id identificador del Oferta
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Oferta
	 * @param entity Oferta a guardar
	 * @return Oferta con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Oferta entity){
		dao.actualizar(entity);
	}
	
	
}
