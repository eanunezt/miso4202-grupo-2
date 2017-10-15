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
@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoREST {
	@EJB
    private ProductoServicio servicio;

	
	/**
	* retorna una lista con los Producto que se encuentran en la base de datos
	* @return retorna una lista de Producto
	* @generated
	*/
	@GET
	public List<Producto> obtenerTodosProductos(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Producto
	* @return Producto del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Producto obtenerProducto(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Producto
	 * @param entity Producto a guardar
	 * @return Producto con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Producto guardarProducto(Producto entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Producto con el identificador dado
	 * @param id identificador del Producto
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarProducto(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
