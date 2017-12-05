package marketplace.dao;

import marketplace.modelo.entity.*;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import marketplace.modelo.enums.*;

/**
  *  @generated
  *  @author eanunezt
  */
@Stateless
public class UsuarioDAO {
	@PersistenceContext
    private EntityManager em;

	
	@PostConstruct
	public void crearUsuarioAdministrador() {
		System.out.println("++++++ Post Construct ++++++");		
		List<Usuario> lu = obtenerTodos();		
		for(Usuario u :lu) {
			if(u.getUsuario().equals("admin")) {
				u.setRol(RolEnum.ADMINISTRADOR);	
			    actualizar(u);
			    System.out.println("Actualizo Rol usuario "+u.getUsuario());
			}
		}
		System.out.println("++++++ Termina Post Construct ++++++");
	}
	
	/**
	* @generated
	*/
	public List<Usuario> obtenerTodos(){
		return em.createNamedQuery("Usuario.obtenerTodos").getResultList();
	}
	
	/**
	* retorna una lista con los Usuario que se encuentran en la base de datos
	* @return retorna una lista de Usuario
	* @generated
	*/
	public List<Usuario> obtenerTodos(Integer startPosition,Integer maxResult){
	
	TypedQuery<Usuario> findAllQuery = em
					.createQuery(
							"SELECT DISTINCT o FROM Usuario o ORDER BY o.id",
							Usuario.class);
			if (startPosition != null) {
				findAllQuery.setFirstResult(startPosition);
			}
			if (maxResult != null) {
				findAllQuery.setMaxResults(maxResult);
			}
			//final List<Oferta> results = findAllQuery.getResultList();
		return findAllQuery.getResultList();
	}
	
	/**
	* @generated
	*/
	public Usuario obtener(Long id){
		return em.find(Usuario.class, id);
	}
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario obtener(String usuario){
		Usuario user = null;
		TypedQuery<Usuario> consultaUsuarioPorUsername = 
		em.createNamedQuery("Usuario.obtenerUsuarioPorNombre", Usuario.class);
		consultaUsuarioPorUsername.setParameter("usuario", usuario);
		List<Usuario> listaUsuario = consultaUsuarioPorUsername.getResultList();
		if(!listaUsuario.isEmpty()){
			user = listaUsuario.get(0);
		}
		return user;
	}	
	
	
	/**
	* @generated
	*/
	public Usuario guardar(Usuario entidad){
		em.persist(entidad);
		return entidad;
	}
	
	
	/**
	* @generated
	*/
	public void borrar(Long id){
		em.remove(em.find(Usuario.class, id));
	}
	
	
	/**
	* @generated
	*/
	public void actualizar(Usuario entidad){
		em.merge(entidad);
	}
	
	
}
