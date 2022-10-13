/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio38;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class Ejercicio38 {

    /**
Ejercicio38. Crear un archivo de texto llamado “fichero38.txt”, introduciendo en un
string el contenido de cada línea y pasarlo al archivo. Cuando se introduzca un string
en blanco, acabamos de grabar el archivo cerrándolo. A continuación leemos el archivo
y grabamos solamente las líneas impares en otro archivo llamado
“fichero38impares.txt”.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String cadena = " ";
        FileReader fr;
        
        File f = new File("fichero38.txt");
        File f2 = new File("fichero38impares.txt");
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
          BufferedWriter bw = new BufferedWriter (new FileWriter ("fichero38.txt", true));
          bw.write(cadena);
          bw.newLine();
          
          bw.close();
          
          
        }catch(IOException e){
            e.printStackTrace();
        }
        }
        try{
        BufferedReader br = new BufferedReader(new FileReader("fichero38.txt"));
        String cadenaLeida = br.readLine();
            int contador = 1;
            
            f2.delete();
            f2.createNewFile();
        while(!cadenaLeida.isEmpty()){
            BufferedWriter bw = new BufferedWriter (new FileWriter("fichero38impares.txt", true));
            if(contador %2 != 0){
                
                bw.write(cadenaLeida);
                bw.newLine();
            }
            
            System.out.println(cadenaLeida);
            cadenaLeida = br.readLine();
            contador++;
            
            bw.close();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException i){
            i.printStackTrace();
        }
        
       
    }
        
    }
    

