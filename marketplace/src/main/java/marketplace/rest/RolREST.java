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
@Path("/rol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolREST {
	@EJB
    private RolServicio servicio;

	
	/**
	* retorna una lista con los Rol que se encuentran en la base de datos
	* @return retorna una lista de Rol
	* @generated
	*/
	@GET
	public List<Rol> obtenerTodosRols(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Rol
	* @return Rol del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Rol obtenerRol(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Rol
	 * @param entity Rol a guardar
	 * @return Rol con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Rol guardarRol(Rol entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Rol con el identificador dado
	 * @param id identificador del Rol
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarRol(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
