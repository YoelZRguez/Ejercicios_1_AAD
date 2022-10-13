package ejercicio23;

import java.io.*; 
import java.io.IOException;


public class Ejercicio23 {
/*
Crear el proyecto “ejercicio23” para guardar en un String el contenido de un fichero “leer3”
que solo tiene una línea.

    */
    
    public static void main(String[] args) {
        String fichero = "";
        try{
           FileReader f = new FileReader ("./leer23.txt");
           int i = 0;
           while (i!=-1){
               
               fichero+=(char)i;
               i = f.read();
               
               
           }
           System.out.println(fichero);
        }catch (FileNotFoundException fnf){
        
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
