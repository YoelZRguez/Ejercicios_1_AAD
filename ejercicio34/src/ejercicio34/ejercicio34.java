/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio34;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
Escribir un nombre de archivo por teclado (“ejercicio34”). En él grabamos una cadena
de caracteres que hemos introducido también por teclado, en un solo acceso al disco.
 */
public class ejercicio34 {

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
          BufferedWriter bw = new BufferedWriter (new FileWriter (nombreArchivo+".txt"));
          for (int i = 0; i<cadena.length(); i++){
          bw.write(cadena.charAt(i));
          }
          
          bw.close();
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
