package marketplace.logger.factoryMethod.producto;

import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	public static String leerPropiedad(String propiedad){
		Properties propiedades = new Properties();
		try {
			propiedades.load(Propiedades.class.getClassLoader().getResourceAsStream("/project.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propiedades.getProperty(propiedad);
	}
}
