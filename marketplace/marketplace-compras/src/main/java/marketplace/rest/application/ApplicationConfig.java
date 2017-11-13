
package marketplace.rest.application;

import java.util.Set;

import javax.ws.rs.core.Application;

import marketplace.rest.CategoriaREST;
import marketplace.rest.CompraREST;
import marketplace.rest.OfertaREST;
import marketplace.rest.ProductoREST;
import marketplace.rest.UsuarioREST;

/**
 * Esta clase registra la informacion de las clases que van a ser utilizadas como servicios REST
 * @author eanunezt
 */
@javax.ws.rs.ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    /*private void addRestResourceClasses(Set<Class<?>> resources) {
       resources.add(CompraREST.class);
    }*/
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(CompraREST.class);
		resources.add(OfertaREST.class);
		resources.add(UsuarioREST.class);
		resources.add(CategoriaREST.class);
		resources.add(ProductoREST.class);
    }
}

