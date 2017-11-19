package marketplace.rest;

import java.io.UnsupportedEncodingException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mindrot.jbcrypt.BCrypt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

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
	
	
	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@POST
	public Usuario login(Usuario entity){
		String username = entity.getUsuario();
		Usuario usuario = servicio.obtener(username);
		try {

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(usuario == null){
			
		}
		else{
			if(!BCrypt.checkpw(entity.getPassword(), usuario.getPassword())){

			}
			else{
				Algorithm algorithm = null;
				try {
					algorithm = Algorithm.HMAC256(entity.getPassword());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String token = JWT.create()
						.withClaim("username", usuario.getUsuario())
				        //.withIssuer("auth0")
				        .sign(algorithm);
				usuario.setToken(token);
			}
		}
		
		System.out.println(entity.getUsuario());
		return usuario;
	}
	
	/**
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	@GET
	public String obtenerTodosUsuarios(){
		return "aaaaaa";
	}
}
