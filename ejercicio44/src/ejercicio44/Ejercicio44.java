/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio44;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
Vamos a crear un “proyecto44” en el que tenemos un array de enteros con el dorsal
de 6 personas: dorsal[6]={22, 5, 7, 11, 14, 8}, otro array con el nombre de los
corredores (los dorsales se asocian al corredor en el orden establecido en el array),
nombre[6]={“Juan”, “Luis”, “Pedro”, “Marcos”, ”Jose”, ”Blas”}. Crear un archivo
“fichero4” en el que grabamos el dorsal y el nombre. A continuación leemos el archivo
para ver si está bien escrito.

 */
public class Ejercicio44 {

    public static void main(String[] args) {
      Scanner sc = new Scanner (System.in);
       
      int dorsal[] = {22, 5, 7, 11, 14, 8};
      String nombre [] = {"Juan", "Luis", "Pedro", "Marcos", "Jose", "Blas"};
      
    try {
            FileOutputStream fos = new FileOutputStream ("fichero4.dat");
            DataOutputStream dos = new DataOutputStream (fos);
        for (int i = 0; i<dorsal.length; i++){
            String escrito = dorsal[i] +"/"+ nombre [i];
            dos.writeUTF(escrito);
        }
    
    fos.close();
    dos.close();
            
    } catch (FileNotFoundException e) {
            e.printStackTrace();
    }catch(IOException e){
            e.printStackTrace();
        }
    
    try{
        FileInputStream fos2 = new FileInputStream ("fichero4.dat");
        DataInputStream dos2 = new DataInputStream (fos2); 
        for (int i = 0; i<dorsal.length; i++){
            System.out.println(dos2.readUTF());
        }
        fos2.close();
        dos2.close();
    }catch(IOException e){
        e.printStackTrace();
    }
            
      
       
        
        
    }
    }
    

