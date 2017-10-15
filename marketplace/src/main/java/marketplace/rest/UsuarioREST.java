package marketplace.rest;

import marketplace.modelo.entity.*;
import marketplace.servicio.*;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
  *  @author eanunezt
  *  @generated
  */
@Stateless
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioREST {
	@EJB
    private UsuarioServicio servicio;

	
	/**
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	@GET
	public List<Usuario> obtenerTodosUsuarios(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Usuario
	* @return Usuario del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Usuario obtenerUsuario(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Usuario
	 * @param entity Usuario a guardar
	 * @return Usuario con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Usuario guardarUsuario(Usuario entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Usuario con el identificador dado
	 * @param id identificador del Usuario
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarUsuario(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
