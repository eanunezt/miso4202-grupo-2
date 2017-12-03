package marketplace.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import marketplace.conf.Propiedades;
import marketplace.conf.Respuesta;
import marketplace.constantes.IConstantesAutenticacion;


@Stateless
@Path("/init")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InitRest {
	/**
	 * almacena la informacion de Compra
	 * @param entity Compra a guardar
	 * @return Compra con los cambios realizados por el proceso de guardar
	 * @generated
	 */
	@GET
	public Response init(){
		String producto = Propiedades.leerPropiedad(IConstantesAutenticacion.NOMBRE_PRODUCTO);
		Respuesta respuesta = new Respuesta();
		respuesta.setNomProducto(producto);
		if(producto.equals(IConstantesAutenticacion.BASICO)){
			respuesta.setContexto(IConstantesAutenticacion.CONTEXTO_BASICO);
			respuesta.setDescripcion(IConstantesAutenticacion.DESC_BASICO);
		}
		else if (producto.equals(IConstantesAutenticacion.COMPRAS)) {
			respuesta.setContexto(IConstantesAutenticacion.CONTEXTO_COMPRAS);
			respuesta.setDescripcion(IConstantesAutenticacion.DESC_COMPRAS);
		}
		return Response.ok(respuesta).build();
	}
}
