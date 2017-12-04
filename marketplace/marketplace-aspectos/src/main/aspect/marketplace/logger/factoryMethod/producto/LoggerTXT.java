package marketplace.logger.factoryMethod.producto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerTXT implements ILogger{

	@Override
	public String crearArchivo(String ruta) {
		return "Crea archivo TXT";
	}

	@Override
	public String escribir(String txt) {		
		FileWriter fw=null;
		BufferedWriter bw= null;
		try {
			fw = new FileWriter("../Logger.txt",true);
			bw = new BufferedWriter(fw);
			bw.write(txt+"\n");
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
		System.out.println("escribe en archivo TXT");
		return "escribe en archivo TXT";
	}

}
