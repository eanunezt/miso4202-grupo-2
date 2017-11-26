package marketplace.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.mindrot.jbcrypt.BCrypt;

import marketplace.anotations.Autowired;
import marketplace.anotations.IMetodoAutenticacion;
import marketplace.conf.MetodoAutenticacion;
import marketplace.modelo.entity.Usuario;
import marketplace.servicio.UsuarioServicio;

/**
 *  @author dmahechav
 *  @generated
 */
@Stateless
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginREST {
	@EJB(lookup="java:global/marketplace-core/UsuarioServicio")
	private UsuarioServicio servicio;

	@IMetodoAutenticacion(tipoAutenticacion="token")
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
		String username = entity.getUsuario();
		Usuario usuario = servicio.obtener(username);
		try {
			if(usuario != null){
				String pw_hash = BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt());
				MetodoAutenticacion metodo = new MetodoAutenticacion();
				if(!metodo.autenticar(this, usuario, pw_hash)){
					return Response.status(Status.UNAUTHORIZED).entity("Error al autenticar el usuario, Verifique que el usuario y la contraseña sean correctos").build();
				}
			}else{
				return Response.status(Status.UNAUTHORIZED).entity("Error al autenticar el usuario, El usuario no se encuentra registrado").build();
			}

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.ok(usuario).build();
	}
}
