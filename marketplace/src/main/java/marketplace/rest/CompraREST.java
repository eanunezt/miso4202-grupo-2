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
@Path("/compra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraREST {
	@EJB
    private CompraServicio servicio;

	
	/**
	* retorna una lista con los Compra que se encuentran en la base de datos
	* @return retorna una lista de Compra
	* @generated
	*/
	@GET
	public List<Compra> obtenerTodosCompras(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Compra
	* @return Compra del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Compra obtenerCompra(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Compra guardarCompra(Compra entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Compra con el identificador dado
	 * @param id identificador del Compra
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarCompra(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
