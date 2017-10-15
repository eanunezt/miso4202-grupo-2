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
@Path("/oferta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OfertaREST {
	@EJB
    private OfertaServicio servicio;

	
	/**
	* retorna una lista con los Oferta que se encuentran en la base de datos
	* @return retorna una lista de Oferta
	* @generated
	*/
	@GET
	public List<Oferta> obtenerTodosOfertas(){
		return servicio.obtenerTodos();
	}
	
	/**
	* @param id identificador del elemento Oferta
	* @return Oferta del id dado
	* @generated
	*/
	@GET
	@Path("/{id}")
	public Oferta obtenerOferta(@PathParam("id") Long id){
		return servicio.obtener(id);
	}
	
	
	/**
	 * almacena la informacion de Oferta
	 * @param entity Oferta a guardar
	 * @return Oferta con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Oferta guardarOferta(Oferta entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        return entity;
	    }else{
	        return servicio.guardar(entity);
	    }
	}
	
	
	/**
	 * elimina el registro Oferta con el identificador dado
	 * @param id identificador del Oferta
	 * @generated 
	 */
	@DELETE
	@Path("/{id}")
	public void borrarOferta(@PathParam("id") Long id){
		servicio.borrar(id);
	}
	
	
}
