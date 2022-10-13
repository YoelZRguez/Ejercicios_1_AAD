/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio31;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class ejercicio31 {

    /**
Llamamos al proyecto “ejercicio31”, al archivo “fichero1”. Declarar una cadena de
caracteres y mediante un bucle, escribirla en un archivo carácter a carácter.

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cadena = "Hola buenas tardes";
        File f = new File("fichero1.txt");
        f.delete();
        
        try{
            
        f.createNewFile();
        
        }catch(IOException e){
        e.printStackTrace();
        }
        
        try{  
          FileWriter fw = new FileWriter ("fichero1.txt");
          for (int i = 0; i<cadena.length(); i++){
          fw.write(cadena.charAt(i));
          
          }
          
          fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
