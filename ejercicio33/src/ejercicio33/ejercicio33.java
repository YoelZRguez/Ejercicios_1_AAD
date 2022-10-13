/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio33;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class ejercicio33 {

    /**
Proyecto “ejercicio33”. Generar un archivo que grabamos carácter a carácter. Lo
introducimos por teclado, el nombre y el contenido, el contenido será de una línea
solamente.
A continuación lo leemos carácter a carácter y mostramos por pantalla.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cadena = "";
        String nombreArchivo;
        FileReader fr;
        
        System.out.println("Introduce el nombre que quieres que tenga el archivo: ");
        nombreArchivo = sc.nextLine();
        
        File f = new File(nombreArchivo+".txt");
        f.delete();
        
        try{
            
        f.createNewFile();
        
        }catch(IOException e){
        e.printStackTrace();
        }
        
        System.out.println("Introduce la cadena para escribir en el archivo: ");
        cadena = sc.nextLine();
        
        try{  
          FileWriter fw = new FileWriter (nombreArchivo+".txt");
          for (int i = 0; i<cadena.length(); i++){
          fw.write(cadena.charAt(i));
          }
          
          fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try{
            int i = 0; 
            fr = new FileReader(nombreArchivo+".txt");
            i = fr.read();
            
            System.out.println("---------------------------------------------");
            System.out.println("El contenido del fichero "+nombreArchivo+".txt es: ");
            
            
            while (i != -1){
            System.out.print((char)i);
            i = fr.read();
            }
            System.out.println("");
            
        }catch (FileNotFoundException e){
            e.printStackTrace();
            
        }catch (IOException i){
            i.printStackTrace();
        }
        
    }
    
}
