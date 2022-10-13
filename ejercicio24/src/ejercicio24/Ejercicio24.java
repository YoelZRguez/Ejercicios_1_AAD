/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio24;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 Contar las vocales de un archivo de texto que hemos creado previamente. Proyecto
“ejercicio24”, fichero “leer4”.
 */
public class Ejercicio24 {

    public static void main(String[] args) {
        int contador = 0; 
        try{
           FileReader f = new FileReader ("./leer24.txt");
           int i = 0;
           while (i!=-1){
               if((char) i == 'a' || (char) i == 'e' || (char) i == 'i' || (char) i == 'o' || (char) i == 'u'  ){
                contador++;
                }else{
                   
               }
               
               i = f.read();
               
               
           }
           System.out.println("Total de vocales: "+contador);
        }catch (FileNotFoundException fnf){
        
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
