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
public class RolServicio {
	@EJB
    private RolDAO dao;


	
	/**
	* retorna una lista con los Rol que se encuentran en la base de datos
	* @return retorna una lista de Rol
	* @generated
	*/
	public List<Rol> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Rol
	* @return Rol del id dado
	* @generated
	*/
	public Rol obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Rol
	 * @param entity Rol a guardar
	 * @return Rol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Rol guardar(Rol entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Rol con el identificador dado
	 * @param id identificador del Rol
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Rol
	 * @param entity Rol a guardar
	 * @return Rol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Rol entity){
		dao.actualizar(entity);
	}
	
	
}
