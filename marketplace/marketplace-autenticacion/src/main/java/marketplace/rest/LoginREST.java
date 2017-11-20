package marketplace.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
	public Usuario login(Usuario entity){

		String username = entity.getUsuario();
		Usuario usuario = servicio.obtener(username);

		if(usuario != null){
			String pw_hash = BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt());
			MetodoAutenticacion metodo = new MetodoAutenticacion();
			if(metodo.autenticar(this, usuario, pw_hash)){
				
			}
			else{
				
			}
		}else{
			
		}
		return usuario;
	}
}
