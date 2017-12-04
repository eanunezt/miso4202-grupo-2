package marketplace.logger.factoryMethod.creador;

import marketplace.logger.factoryMethod.producto.ILogger;

public abstract class CreatorLogger {
	public abstract ILogger loggerTXT(String ruta);
	public abstract ILogger loggerXML(String ruta);
}
