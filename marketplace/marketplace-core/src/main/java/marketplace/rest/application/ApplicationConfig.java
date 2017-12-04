
package marketplace.rest.application;

import java.util.Set;
import javax.ws.rs.core.Application;
import marketplace.rest.*;

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
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(OfertaREST.class);resources.add(UsuarioREST.class);resources.add(CategoriaREST.class);resources.add(ProductoREST.class);
        resources.add(InitRest.class);
    }
    
}

