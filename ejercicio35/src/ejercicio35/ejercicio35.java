/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio35;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class ejercicio35 {

    /**
En el “ejercicio35” vamos a crear el archivo de texto “fichero35” escribiendo string que
vamos grabando al archivo línea a línea. Dejamos de introducir líneas al introducir un
string vacío (pulsamos intro).
Después de cerrar el archivo, lo abrimos para lectura y lo mostramos por pantalla.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cadena = " ";
        FileReader fr;
        
        File f = new File("fichero35.txt");
        f.delete();
        
        try{
            
        f.createNewFile();
        
        }catch(IOException e){
        e.printStackTrace();
        }
        
        
        
        while (!cadena.isEmpty()){
        System.out.println("Introduce la cadena para escribir en el archivo: ");
        cadena = sc.nextLine();
        try{  
          BufferedWriter bw = new BufferedWriter (new FileWriter ("fichero35.txt", true));
          bw.write(cadena);
          bw.newLine();
          
          bw.close();
          
          
        }catch(IOException e){
            e.printStackTrace();
        }
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("fichero35.txt"));
            String cadenaLeida = br.readLine();
            
            while(!cadenaLeida.isEmpty()){
            
            System.out.println(cadenaLeida);
            cadenaLeida = br.readLine();
            }
            
            
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException i){
            i.printStackTrace();
        }
        
       
    }
    
}
