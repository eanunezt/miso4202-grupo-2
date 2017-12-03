package marketplace.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import marketplace.anotations.Autowired;
import marketplace.anotations.IMetodoAutenticacion;
import marketplace.conf.Error;
import marketplace.conf.MetodoAutenticacion;
import marketplace.dto.Usuario;

/**
 *  @author dmahechav
 *  @generated
 */
@Stateless
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginREST {
	@IMetodoAutenticacion
	@Autowired
	MetodoAutenticacion autenticacion;

	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Response login(Usuario entity){
		Error error = new Error();
		try {
			if(entity != null){
				MetodoAutenticacion metodo = new MetodoAutenticacion();
				if(!metodo.autenticar(this, entity)){
					error.setDescError("Error al autenticar el usuario, Verifique que el usuario y la contraseña sean correctos");
					error.setTipoError(Status.UNAUTHORIZED.toString());
					return Response.status(Status.UNAUTHORIZED).entity(error).build();
				}
			}else{
				error.setDescError("Error al autenticar el usuario, El usuario no se encuentra registrado");
				error.setTipoError(Status.UNAUTHORIZED.toString());
				return Response.status(Status.UNAUTHORIZED).entity(error).build();
			}

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		entity.setPasswd("");
		return Response.ok(entity).build();
	}
}