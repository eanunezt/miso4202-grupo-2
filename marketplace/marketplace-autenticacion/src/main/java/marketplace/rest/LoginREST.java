package marketplace.rest;

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
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

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
	public Usuario login(Usuario entity){
		
		String username = entity.getUsuario();
		Usuario usuario = servicio.obtener(username);
		String pw_hash = BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt());
		
		MetodoAutenticacion metodo = new MetodoAutenticacion();
		metodo.autenticar(this, usuario, pw_hash);

		
		
		
		/*Algorithm algorithm = null;
		try {
			algorithm = Algorithm.HMAC256(entity.getPassword());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		String token = JWT.create()
				.withClaim("username", username)
		        //.withIssuer("auth0")
		        .sign(algorithm);
		
		Algorithm algorithm1 = Algorithm.HMAC256(entity.getPassword());
		JWTVerifier verifier = JWT.require(algorithm)
				.withClaim("username", username)
				.build(); //Reusable verifier instance
		DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImp0aSI6ImEzYmQxMTNkLTVkNWYtNGI0MC05MTg5LTg2MWEzY2IwYzZiMyIsImlhdCI6MTUxMTAzMDA3NiwiZXhwIjoxNTExMDMzNjc2fQ.0ZWW0WzFzOZPjKExT5-DUz9vssVuwvPLDOlg0ho56O8");

		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (JWTVerificationException e){
			e.printStackTrace();
		}		
		//usuario.setToken(token);
		
		
		try {

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		if(usuario == null){
			
		}
		else{
			if(!BCrypt.checkpw(entity.getPassword(), usuario.getPassword())){

			}
			else{


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
