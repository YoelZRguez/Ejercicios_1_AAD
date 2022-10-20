/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio42;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
En el proyecto “ejercicio42”, en el archivo “fichero2.dat”, escribimos el nombre y la
edad de los alumnos. Finalizamos con intro.
 */
public class Ejercicio42 {

    
    
    public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       int edad = 0;
       String nombre = " ";
       
        try {
            FileOutputStream fic = new FileOutputStream("fichero42.dat");
            DataOutputStream f1 = new DataOutputStream(fic);
            do{
                
                System.out.print("Introduce tu nombre: ");
                nombre = sc.nextLine();
                f1.writeUTF(nombre);
            if(!nombre.isEmpty()){
                System.out.print("Introduce tu edad: ");
                edad = Integer.parseInt(sc.nextLine());
                System.out.println("-------------------------------------------");
                f1.writeInt(edad);
            }
                
                
            
            }while(!nombre.isEmpty());
            fic.close();
            f1.close();
      
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(EOFException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
