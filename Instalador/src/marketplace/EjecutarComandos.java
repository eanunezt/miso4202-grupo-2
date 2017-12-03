/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    public String ejecutar(){
        String resIn="",resEr="",temp="";
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
            
        } catch (IOException ex) {
            Logger.getLogger(EjecutarComandos.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }       
        
        return resIn +"\n"+ resEr+"\n";
    }
}
