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
public class CategoriaServicio {
	@EJB
    private CategoriaDAO dao;


	
	/**
	* retorna una lista con los Categoria que se encuentran en la base de datos
	* @return retorna una lista de Categoria
	* @generated
	*/
	public List<Categoria> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	
	/**
	* retorna una lista con los Categoria que se encuentran en la base de datos
	* @return retorna una lista de Categoria
	* @generated
	*/
	public List<Categoria> obtenerTodos(Integer startPosition,Integer maxResult){
		return dao.obtenerTodos(startPosition,maxResult);
	}
	
	
	
	/**
	* @param id identificador del elemento Categoria
	* @return Categoria del id dado
	* @generated
	*/
	public Categoria obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Categoria
	 * @param entity Categoria a guardar
	 * @return Categoria con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Categoria guardar(Categoria entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Categoria con el identificador dado
	 * @param id identificador del Categoria
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Categoria
	 * @param entity Categoria a guardar
	 * @return Categoria con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Categoria entity){
		dao.actualizar(entity);
	}
	
	
}
