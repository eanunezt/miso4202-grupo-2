/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class ManejaArchivo {
    String ruta;
    boolean[] caracteristicas;
    public ManejaArchivo(String ruta,boolean[] caracteristicas){
        this.ruta=ruta;
        this.caracteristicas=caracteristicas;      
    }

    public ManejaArchivo(){
    }
    
    public String crearArchivoTXT() {
        String txt ="tipo.autenticacion=token"+System.lineSeparator();
        
        if(caracteristicas[0]==true)
            txt+="nombre.producto=basico"+System.lineSeparator();
        if(caracteristicas[1]==true)
            txt+="nombre.producto=compras"+System.lineSeparator();
        if(caracteristicas[2]==true)
            txt+="pagoPSE=SI"+System.lineSeparator(); 
        else
            txt+="pagoPSE=NO"+System.lineSeparator();
        if(caracteristicas[3]==true)
            txt+="logger=TXT"+System.lineSeparator(); 
        if(caracteristicas[4]==true)
            txt+="logger=XML"+System.lineSeparator();
        
        System.out.println(txt);  
        return crearArchivo(ruta+"project.properties",txt);
    }
    
    public String crearArchivoXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"
                + "<aplicacion nombre= \"MarketPlace UniViajes\"> \n";
        
        if(caracteristicas[1]==true){
            xml+= "<tipo>Comercio</tipo>"+System.lineSeparator();
        }else{
            xml+= "<tipo>Basico</tipo>"+System.lineSeparator();
        }
        xml+="<modulos>"+System.lineSeparator();
        if(caracteristicas[0]==true)
            xml+="<modulo>Basico</modulo>"+System.lineSeparator();
        if(caracteristicas[1]==true)
            xml+="<modulo>Compra</modulo>"+System.lineSeparator();
        if(caracteristicas[2]==true)
            xml+="<modulo>pagoPSE</modulo>"+System.lineSeparator();  
        if(caracteristicas[3]==true)
            xml+="<modulo>LoggerTXT</modulo>"+System.lineSeparator();
        if(caracteristicas[4]==true)
            xml+="<modulo>LoggerXML</modulo>"+System.lineSeparator();
        xml+="</modulos>"+System.lineSeparator()+"</aplicacion>";
        
        System.out.println(xml);  
        return crearArchivo(ruta+"project.xml",xml);
    }

    private String crearArchivo(String ruta,String text)  {       
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            bw.append(text);
            
            return "Archivo Propiedades creado!";
            
        } catch (IOException ex) {
            Logger.getLogger(ManejaArchivo.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
                
            }catch(IOException e){
                 Logger.getLogger(ManejaArchivo.class.getName()).log(Level.SEVERE, null, e);
                 return e.getMessage();
            }
        }        
    }
    
    public List<String> cargarArchivo(String nombre){
        String path = getClass().getResource(nombre).getPath();
        List<String> res = new ArrayList<String>();
        try {
            FileReader fr = new  FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fr);           
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                    res.add(line);
            }
            if(fr!=null)
                fr.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            return res;
        }
    }
    
}
