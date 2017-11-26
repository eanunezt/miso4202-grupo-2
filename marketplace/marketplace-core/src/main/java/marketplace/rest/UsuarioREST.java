package marketplace.rest;

import java.io.UnsupportedEncodingException;
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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import marketplace.modelo.entity.Usuario;
import marketplace.servicio.UsuarioServicio;
/**
 *  @author eanunezt
 *  @generated
 */
@Stateless
@Path("/usuarios")
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

	@GET
	@Produces("application/json")
	public List<Usuario> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {

		final List<Usuario> results = servicio.obtenerTodos(startPosition,maxResult);//findAllQuery.getResultList();
		return results;
	}

	/**
	 * @param id identificador del elemento Usuario
	 * @return Usuario del id dado
	 * @generated
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response obtenerUsuario(@PathParam("id") Long id){
		Usuario entity;
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
	 * almacena la informacion de Usuario
	 * @param entity Usuario a guardar
	 * @return Usuario con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	@Path("/")
	public Response guardarUsuario(Usuario entity){
		try {
			if(entity.getPassword() != null){
				Algorithm algorithm = Algorithm.HMAC256(entity.getPassword());
				String token = JWT.create()
						.withClaim("username", entity.getUsuario())
				        .sign(algorithm);
				entity.setPassword(token);
			} 
			if(entity.getId()!=null){
				servicio.actualizar(entity);
			}else{
				servicio.guardar(entity);
			}
		}
		catch (IllegalArgumentException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.created(
				UriBuilder.fromResource(UsuarioREST.class)
				.path(String.valueOf(entity.getId())).build()).build();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Usuario entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		/*if (em.find( Usuario.class, id) == null) {
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
	 * elimina el registro Usuario con el identificador dado
	 * @param id identificador del Usuario
	 * @generated 
	 */
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response  borrarUsuario(@PathParam("id") Long id){
		try{
			servicio.borrar(id);
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.noContent().build();
	}


}
