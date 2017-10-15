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
public class ProductoServicio {
	@EJB
    private ProductoDAO dao;


	
	/**
	* retorna una lista con los Producto que se encuentran en la base de datos
	* @return retorna una lista de Producto
	* @generated
	*/
	public List<Producto> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Producto
	* @return Producto del id dado
	* @generated
	*/
	public Producto obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Producto
	 * @param entity Producto a guardar
	 * @return Producto con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Producto guardar(Producto entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Producto con el identificador dado
	 * @param id identificador del Producto
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Producto
	 * @param entity Producto a guardar
	 * @return Producto con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Producto entity){
		dao.actualizar(entity);
	}
	
	
}
