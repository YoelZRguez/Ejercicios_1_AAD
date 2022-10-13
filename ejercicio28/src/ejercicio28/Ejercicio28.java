/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio28;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
Leer el archivo de texto “leer8” línea a línea y contar el número de líneas del
archivo, mostrándolo por pantalla. Proyecto “ejercicio28”.
 */
public class Ejercicio28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0; 
        try{
           BufferedReader bf = new BufferedReader( new FileReader ("./leer28.txt"));
           String texto = bf.readLine();
           while (texto != null){
            contador ++; 
            texto = bf.readLine();
            
               }
           bf.close();

           System.out.println("Total de líneas: "+contador);
        }catch (FileNotFoundException fnf){
        
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
    
    
