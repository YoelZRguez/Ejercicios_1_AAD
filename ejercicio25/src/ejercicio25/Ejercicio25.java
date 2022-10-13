/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 Contar el número de líneas del archivo “leer5” en el proyecto “ejercicio25”
 */
public class Ejercicio25 {

    
    public static void main(String[] args) {
         int contador = 0; 
         File file = new File ("leer25.txt");
         
        try{
            Scanner sc = new Scanner (file);
           FileReader f = new FileReader ("./leer25.txt");
           while (sc.hasNextLine()){
           sc.nextLine();
           contador++; 
           }
            System.out.println("Total de líneas: "+contador);
        }catch (FileNotFoundException fnf){
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}