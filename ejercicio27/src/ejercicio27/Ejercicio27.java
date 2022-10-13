/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio27;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yoelzr
 */
public class Ejercicio27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int contador = 0; 
        try{
           FileReader f = new FileReader ("./leer27.txt");
           int i = 0;
           while (i!=-1){
               if(i >= 65 && i<=90 ){
                contador++;
                }else{
                   
               }
               
               i = f.read();
               
               
           }
           System.out.println("Total de mayúsculas: "+contador);
        }catch (FileNotFoundException fnf){
        
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
    
    

