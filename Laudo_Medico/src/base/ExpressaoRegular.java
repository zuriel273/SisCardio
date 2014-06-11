/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arlindo
 */
public class ExpressaoRegular {
    /**
     * 
     * @param texto
     * @return TRUE se é iniciado com caracter alfabetico FALSE cc
     * 
     */
    public boolean isTextoInicialSemNum(String texto){
        Pattern pattern = Pattern.compile("^[a-zA-Z]");
        Matcher matcher = pattern.matcher(texto);
        
        return matcher.find();
    }
    /**
     * 
     * @param texto
     * @return TRUE se é somente texto FALSE cc.
     * 
     */
    public boolean isTexto(String texto){
        Pattern pattern = Pattern.compile("[:alpha]( |[a-zA-Z])*$");
        Matcher matcher = pattern.matcher(texto);
        
        return matcher.find();
    }
    
    /**
     * 
     * @param texto
     * @return TRUE se é númerico FALSE cc.
     * 
     */
    public boolean isNum(String texto){
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(texto);
        
        return matcher.find();
    }
}
