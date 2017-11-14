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
public class UsuarioServicio {
	@EJB
    private UsuarioDAO dao;


	
	/**
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	public List<Usuario> obtenerTodos(){
		return dao.obtenerTodos();
	}
	
	
	/**
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	public List<Usuario> obtenerTodos(Integer startPosition,Integer maxResult){
		return dao.obtenerTodos(startPosition,maxResult);
	}
	

	/**
	* @param usuario nombre de usuario del elemento Usuario
	* @return Usuario del nombre de usuario dado
	* @generated
	*/
	public Usuario obtener(String usuario){
		return dao.obtener(usuario);
	}		
	
	
	/**
	* @param id identificador del elemento Usuario
	* @return Usuario del id dado
	* @generated
	*/
	public Usuario obtener(Long id){
		return dao.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Usuario
	 * @param entity Usuario a guardar
	 * @return Usuario con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public Usuario guardar(Usuario entity){
		return dao.guardar(entity);
	}
	
	
	/**
	 * Elimina el registro Usuario con el identificador dado
	 * @param id identificador del Usuario
	 * @generated 
	 */
	public void borrar(Long id){
		dao.borrar(id);
	}
	
	
	/**
	 * actualiza la informacion de Usuario
	 * @param entity Usuario a guardar
	 * @return Usuario con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	public void actualizar(Usuario entity){
		dao.actualizar(entity);
	}
	
	
}
