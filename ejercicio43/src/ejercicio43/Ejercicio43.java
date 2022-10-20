/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio43;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
Proyecto “ejercicio43”. En el archivo “fichero31.dat”, escribimos edad, nombre, altura
y peso de 3 personas. Vamos a crear otro archivo “fichero32.dat” en el que escribimos
solamente el nombre y la edad.

 */
public class Ejercicio43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       
       int edad = 0;
       String nombre = " ";
       float peso, altura;
       
        try {
            FileOutputStream fic = new FileOutputStream("fichero31.dat");
            DataOutputStream f1 = new DataOutputStream(fic);
            FileOutputStream fos = new FileOutputStream("fichero32.dat");
            DataOutputStream f2 = new DataOutputStream(fos);
        for (int i= 0; i<4; i++){
                
                System.out.print("Introduce tu nombre: ");
                nombre = sc.nextLine();
                
                System.out.print("Introduce tu edad: ");
                edad = Integer.parseInt(sc.nextLine());
                System.out.print("Introduce tu altura: ");
                altura = Float.parseFloat(sc.nextLine());
                System.out.print("Introduce tu peso: ");
                peso = Float.parseFloat(sc.nextLine());
                f1.writeUTF(nombre);
                f1.writeInt(edad);
                f1.writeFloat(altura);
                f1.writeFloat(peso);
                f2.writeInt(edad);
                f2.writeUTF(nombre);
            
            
        }
            
            
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
