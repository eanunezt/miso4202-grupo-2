package marketplace.logger.factoryMethod.producto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerXML implements ILogger {

	@Override
	public String crearArchivo(String ruta) {
		
		return "Creo archivoXML";
	}

	@Override
	public String escribir(String txt) {
		File f =null;
		FileWriter fw=null;
		BufferedWriter bw= null;
		boolean encabezado=false;
		try {
			f = new File("../Logger.xml");
			if(!f.exists())
				encabezado=true;				
			fw = new FileWriter(f,true);
			bw = new BufferedWriter(fw);	
			if(encabezado)
				bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n");
			bw.write("<log>"+txt+"</log>"+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(bw!= null)
						bw.close();
					
					if(fw!= null)
						fw.close();
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		System.out.println("escribe en archivo XML");
		return "Escribe en archivoXML";
	}

}
