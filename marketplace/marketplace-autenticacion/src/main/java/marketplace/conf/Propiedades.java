package marketplace.conf;

import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	public static String leerPropiedad(){
		Properties propiedades = new Properties();
		try {
			propiedades.load(Propiedades.class.getClassLoader().getResourceAsStream("/project.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(propiedades.getProperty("tipo.autenticacion"));
		return propiedades.getProperty("tipo.autenticacion");
	}
	
	public static void main(String[] args) {
		Propiedades p = new Propiedades();
		p.leerPropiedad();
	}
}
