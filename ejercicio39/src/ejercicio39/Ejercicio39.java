/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio39;

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
public class Ejercicio39 {

    /**
Ejercicio39. Creamos el archivo de texto “fichero39.txt” como en el ejercicio anterior.
Después grabamos el contenido de ese archivo en otro llamado ”fichero39segido.txt”
sin espacios ni saltos de línea.
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String contenido = " ";
        File f = new File("fichero39.txt");
        File f2 = new File("fichero39Seguido.txt");
        
        f.delete();
        f2.delete();
        
        try{
            
            f.createNewFile();
            f2.createNewFile();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        while(!contenido.isEmpty()){
                System.out.println("Introduce el contenido que deseas llevar al fichero: ");
                contenido = sc.nextLine();   
            try{
         
                BufferedWriter bw = new BufferedWriter (new FileWriter ("fichero39.txt", true)); 
                bw.write(contenido);
                bw.newLine();
            
                bw.close();
            
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
            try{
                BufferedWriter bw2 = new BufferedWriter (new FileWriter ("fichero39seguido.txt"));
                BufferedReader br = new BufferedReader(new FileReader ("fichero39.txt"));
                int i = br.read();
                
        while(i != -1){
            if(i==10 || i==32){
                
            }else{
                System.out.println((char)i);
                bw2.write((char)i);
            }
                i = br.read();
        }
            bw2.close();
            br.close();
                
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException i){
                i.printStackTrace();
            }
        
               
    }
}
    

