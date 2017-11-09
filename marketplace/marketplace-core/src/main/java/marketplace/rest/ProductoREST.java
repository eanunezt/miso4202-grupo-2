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

import marketplace.modelo.entity.Producto;
import marketplace.servicio.ProductoServicio;
/**
  *  @author eanunezt
  *  @generated
  */
@Stateless
@Path("/productos")
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
	
	@GET
		@Produces("application/json")
		public List<Producto> listAll(@QueryParam("start") Integer startPosition,
				@QueryParam("max") Integer maxResult) {
	
			final List<Producto> results = servicio.obtenerTodos(startPosition,maxResult);//findAllQuery.getResultList();
			return results;
		}
	
	/**
	* @param id identificador del elemento Producto
	* @return Producto del id dado
	* @generated
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response obtenerProducto(@PathParam("id") Long id){
	Producto entity;
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
	 * almacena la informacion de Producto
	 * @param entity Producto a guardar
	 * @return Producto con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Response guardarProducto(Producto entity){
	    if(entity.getId()!=null){
	        servicio.actualizar(entity);
	        //return entity;
	    }else{
	       servicio.guardar(entity);
	    }
	return Response.created(
					UriBuilder.fromResource(ProductoREST.class)
							.path(String.valueOf(entity.getId())).build()).build();
	}
	
		@PUT
		@Path("/{id:[0-9][0-9]*}")
		@Consumes("application/json")
		public Response update(@PathParam("id") Long id, Producto entity) {
			if (entity == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (id == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			if (!id.equals(entity.getId())) {
				return Response.status(Status.CONFLICT).entity(entity).build();
			}
			/*if (em.find( Producto.class, id) == null) {
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
	 * elimina el registro Producto con el identificador dado
	 * @param id identificador del Producto
	 * @generated 
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response  borrarProducto(@PathParam("id") Long id){
	try{
	servicio.borrar(id);
	} catch (Exception e) {
				return Response.status(Status.NOT_FOUND).build();
			}
	return Response.noContent().build();
	}
	
	
}
