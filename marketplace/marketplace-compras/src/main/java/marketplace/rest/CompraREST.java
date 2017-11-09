package marketplace.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import marketplace.modelo.entity.Compra;
import marketplace.servicio.CompraServicio;
/**
  *  @author eanunezt
  *  @generated
  */
@Stateless
@Path("/compras")
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
	
	@GET
		@Produces("application/json")
		public List<Compra> listAll(@QueryParam("start") Integer startPosition,
				@QueryParam("max") Integer maxResult) {
	
			final List<Compra> results = servicio.obtenerTodos(startPosition,maxResult);//findAllQuery.getResultList();
			return results;
		}
	
	/**
	* @param id identificador del elemento Compra
	* @return Compra del id dado
	* @generated
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response obtenerCompra(@PathParam("id") Long id){
	Compra entity;
	try {
				entity = servicio.obtener(id);
			} catch (NoResultException nre) {
				entity = null;
			}
			if (entity == null) {
				return Response.status(Status.NOT_FOUND).build();
			}
			return Response.ok(entity).build();
	}
	
	
	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Response guardarCompra(Compra entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        //return entity;
	    }else{
	       servicio.guardar(entity);
	    }
	return Response.created(
					UriBuilder.fromResource(CompraREST.class)
							.path(String.valueOf(entity.getId())).build()).build();
	}
	
		@PUT
		@Path("/{id:[0-9][0-9]*}")
		@Consumes("application/json")
		public Response update(@PathParam("id") Long id, Compra entity) {
			if (entity == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (id == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (!id.equals(entity.getId())) {
				return Response.status(Status.CONFLICT).entity(entity).build();
			}
			/*if (em.find( Compra.class, id) == null) {
				return Response.status(Status.NOT_FOUND).build();
			}*/
			try {
				servicio.actualizar(entity);
				//entity = em.merge(entity);
			} catch (OptimisticLockException e) {
				return Response.status(Response.Status.CONFLICT)
						.entity(e.getEntity()).build();
			}
	
			return Response.noContent().build();
		}
	
	
	/**
	 * elimina el registro Compra con el identificador dado
	 * @param id identificador del Compra
	 * @generated 
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response  borrarCompra(@PathParam("id") Long id){
	try{
	servicio.borrar(id);
	} catch (Exception e) {
				return Response.status(Status.NOT_FOUND).build();
			}
	return Response.noContent().build();
	}
	
	
}
