/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio32;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class ejercicio32 {

    /**
En el proyecto “ejercicio32”, en el archivo “fichero2”, hacer lo mismo introduciendo la
cadena por teclado.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cadena = "";
        File f = new File("fichero2.txt");
        f.delete();
        
        try{
            
        f.createNewFile();
        
        }catch(IOException e){
        e.printStackTrace();
        }
        
        System.out.println("Introduce la cadena para escribir en el archivo: ");
        cadena = sc.nextLine();
        
        try{  
          FileWriter fw = new FileWriter ("fichero2.txt");
          for (int i = 0; i<cadena.length(); i++){
          fw.write(cadena.charAt(i));
          
          }
          
          fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
