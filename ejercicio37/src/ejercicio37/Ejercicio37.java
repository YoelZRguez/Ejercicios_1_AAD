/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio37;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class Ejercicio37 {

 /**
Crear un libro de firmas (“ejercicio37”) en el que introducimos nombres de visitantes.
No debe haber nombres repetidos. Cada vez que se añade un nombre, se comprueba
que ese nombre no figura en el libro
     */
    public static void main(String[] args) {
        ArrayList <String>nombres = new ArrayList <String>();
        Scanner sc = new Scanner (System.in);
        File f = new File ("LibroDeFirmas.txt");
        FileReader fr;
        String nombre = " ";
        
        
        
        try{
           f.delete();
           f.createNewFile();
           
            while(!nombre.isEmpty()){
            System.out.println("Introduce el nombre para la firma");
            System.out.print("> ");
            nombre = sc.nextLine();
            
            BufferedReader br = new BufferedReader(new FileReader("LibroDeFirmas.txt"));
            String cadena = br.readLine();
            nombre = nombre.toUpperCase();
            
            if(nombres.contains(nombre) == false ){
                nombres.add(nombre);
                BufferedWriter bwr = new BufferedWriter(new FileWriter("LibroDeFirmas.txt", true));
                bwr.write(nombre+"\n");
                bwr.close();
            }else{
                System.out.println("Nombre no válido, ya se ha firmado con él!");
                System.out.println("");
            }
                
            }
            
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        
        
    }
    
}
