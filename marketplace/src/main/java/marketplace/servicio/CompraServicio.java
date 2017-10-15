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
public class CompraServicio {
	@EJB
    private CompraDAO dao;


	
	/**
	* retorna una lista con los Compra que se encuentran en la base de datos
	* @return retorna una lista de Compra
	* @generated
	*/
	public List<Compra> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Compra
	* @return Compra del id dado
	* @generated
	*/
	public Compra obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Compra guardar(Compra entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Compra con el identificador dado
	 * @param id identificador del Compra
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Compra entity){
		dao.actualizar(entity);
	}
	
	
}
