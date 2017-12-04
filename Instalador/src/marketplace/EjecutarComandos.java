/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class EjecutarComandos {
    
    String cmd;
    public EjecutarComandos(String cmd){
        this.cmd="cmd /c "+cmd;        
    }
    
    public EjecutarComandos(){ 
        this.cmd=null;
        
    }
        
    public String ejecutarBAT(String nombreBat){
        String resIn="",resEr="",temp="";
        File f = new File(nombreBat);
        if(f.exists()){
            String bat = "cmd /c start "+f.getAbsolutePath();
            System.out.println(bat);
            try {            
                Process proc = Runtime.getRuntime().exec(bat);            
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));            
                BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));            
                while ((temp = stdInput.readLine()) != null) {
                    resIn+=temp+"\n";
                }            
                while ((temp = stdError.readLine()) != null) {
                    resEr+=temp+"\n";
                }  
                proc.waitFor();
                proc.destroy();
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarComandos.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            } catch (IOException ex) {
                Logger.getLogger(EjecutarComandos.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }       
        }else{
          return "No existe el archivo "+f.getAbsolutePath();   
        }
        return resIn +"\n"+ resEr+"\n";
    }
    
    public String ejecutar(String cmd){
        String resIn="",resEr="",temp="";
        if(this.cmd!=null){
            cmd="cmd /c "+cmd;
        }
        try {
            
            Process proc = Runtime.getRuntime().exec(cmd);
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            
            while ((temp = stdInput.readLine()) != null) {
                resIn+=temp+"\n";
            }
            
            while ((temp = stdError.readLine()) != null) {
                resEr+=temp+"\n";
            }
            
            proc.destroy();
        } catch (IOException ex) {
            Logger.getLogger(EjecutarComandos.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }       
        
        return resIn +"\n"+ resEr+"\n";
    }
    
    
    public String ejecutar(String[] cmds){
        String resIn="",resEr="",temp="";
        
        try {
            
            Process proc = Runtime.getRuntime().exec(cmds);
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            
            while ((temp = stdInput.readLine()) != null) {
                resIn+=temp+"\n";
            }
            
            while ((temp = stdError.readLine()) != null) {
                resEr+=temp+"\n";
            }
            proc.destroy();
            
        } catch (IOException ex) {
            Logger.getLogger(EjecutarComandos.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }       
        
        return resIn +"\n"+ resEr+"\n";
    }
}
