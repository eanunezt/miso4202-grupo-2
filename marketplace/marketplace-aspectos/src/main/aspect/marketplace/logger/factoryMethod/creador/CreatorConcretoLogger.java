package marketplace.logger.factoryMethod.creador;

import marketplace.logger.factoryMethod.producto.ILogger;
import marketplace.logger.factoryMethod.producto.LoggerTXT;
import marketplace.logger.factoryMethod.producto.LoggerXML;

public class CreatorConcretoLogger extends CreatorLogger{
	
		
	public ILogger logger(String propiedad) {
		if(propiedad.equals("TXT")) {  //variable Logger TXT
			return loggerTXT("ruta");				
		}
		else if(propiedad.equals("XML")) {  //variable Logger XML
			return loggerXML("ruta");				
		}
		return null;
	}
	@Override
	public ILogger loggerTXT(String ruta) {
		// TODO Auto-generated method stub
		return new LoggerTXT();
	}

	@Override
	public ILogger loggerXML(String ruta) {
		// TODO Auto-generated method stub
		return new LoggerXML();
	}

	

}
