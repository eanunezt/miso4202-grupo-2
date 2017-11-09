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

import marketplace.modelo.entity.Oferta;
import marketplace.servicio.OfertaServicio;
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
	
	@GET
		@Produces("application/json")
		public List<Oferta> listAll(@QueryParam("start") Integer startPosition,
				@QueryParam("max") Integer maxResult) {
	
			final List<Oferta> results = servicio.obtenerTodos(startPosition,maxResult);//findAllQuery.getResultList();
			return results;
		}
	
	/**
	* @param id identificador del elemento Oferta
	* @return Oferta del id dado
	* @generated
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response obtenerOferta(@PathParam("id") Long id){
	Oferta entity;
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
	 * almacena la informacion de Oferta
	 * @param entity Oferta a guardar
	 * @return Oferta con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Response guardarOferta(Oferta entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        //return entity;
	    }else{
	       servicio.guardar(entity);
	    }
	return Response.created(
					UriBuilder.fromResource(OfertaREST.class)
							.path(String.valueOf(entity.getId())).build()).build();
	}
	
		@PUT
		@Path("/{id:[0-9][0-9]*}")
		@Consumes("application/json")
		public Response update(@PathParam("id") Long id, Oferta entity) {
			if (entity == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (id == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (!id.equals(entity.getId())) {
				return Response.status(Status.CONFLICT).entity(entity).build();
			}
			/*if (em.find( Oferta.class, id) == null) {
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
	 * elimina el registro Oferta con el identificador dado
	 * @param id identificador del Oferta
	 * @generated 
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response  borrarOferta(@PathParam("id") Long id){
	try{
	servicio.borrar(id);
	} catch (Exception e) {
				return Response.status(Status.NOT_FOUND).build();
			}
	return Response.noContent().build();
	}
	
	
}
