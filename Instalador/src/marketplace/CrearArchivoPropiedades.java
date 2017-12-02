/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class CrearArchivoPropiedades {
    String ruta;
    boolean[] caracteristicas;
    public CrearArchivoPropiedades(String ruta,boolean[] caracteristicas){
        this.ruta=ruta;
        this.caracteristicas=caracteristicas;      
    }

    private String crearTextoArchivo() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"
                + "<aplicacion nombre= \"MarketPlace UniViajes\"> \n";
        
        if(caracteristicas[1]==true){
            xml+= "<tipo>Comercio</tipo> \n";
        }else{
            xml+= "<tipo>Basico</tipo> \n";
        }
        xml+="<modulos> \n";
        if(caracteristicas[0]==true)
            xml+="<modulo>Basico</modulo> \n";
        if(caracteristicas[1]==true)
            xml+="<modulo>Compra</modulo> \n";
        if(caracteristicas[2]==true)
            xml+="<modulo>PSE</modulo> \n";        
        xml+="</modulos> \n</aplicacion> ";
        
        System.out.println(xml);        
        return xml;        
    }

    public String crearArchivo()  {
        String xml = crearTextoArchivo();
        
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(ruta);
            bw = new BufferedWriter(fw);
            bw.append(xml);
            
            return "Archivo Propiedades creado!";
            
        } catch (IOException ex) {
            Logger.getLogger(CrearArchivoPropiedades.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
                
            }catch(IOException e){
                 Logger.getLogger(CrearArchivoPropiedades.class.getName()).log(Level.SEVERE, null, e);
                 return e.getMessage();
            }
        }
        
        
        
    }
    
}
