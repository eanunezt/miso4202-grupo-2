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
@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaREST {
	@EJB
    private CategoriaServicio servicio;

	
	/**
	* retorna una lista con los Categoria que se encuentran en la base de datos
	* @return retorna una lista de Categoria
	* @generated
	*/
	@GET
	public List<Categoria> obtenerTodosCategorias(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Categoria
	* @return Categoria del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Categoria obtenerCategoria(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Categoria
	 * @param entity Categoria a guardar
	 * @return Categoria con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Categoria guardarCategoria(Categoria entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Categoria con el identificador dado
	 * @param id identificador del Categoria
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCategoria(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
