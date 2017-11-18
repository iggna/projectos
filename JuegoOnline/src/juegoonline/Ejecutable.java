/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoonline;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ejecutable {
    public static void main (String args[]){
        
        JuegoOnline pepe=new JuegoOnline();
        try {
            pepe.readDataBase();
        } catch (Exception ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
