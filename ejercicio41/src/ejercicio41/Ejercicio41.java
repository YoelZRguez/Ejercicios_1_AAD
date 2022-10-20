/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio41;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
Llamamos al proyecto “ejercicio41”, en el archivo “fichero1.dat”, escribimos bytes, los
números 0 al 99 y los leemos.
 */
public class Ejercicio41 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        try {
            FileOutputStream fic = new FileOutputStream("fichero1.dat");
            DataOutputStream f1 = new DataOutputStream(fic);
        for (int i = 0; i<100; i++){
            f1.writeByte(i);
        }   
        
        fic.close();
        
            FileInputStream fis = new FileInputStream ("fichero1.dat");
            DataInputStream dis = new DataInputStream(fis);
            
        for (int i = 0; i<100; i++){
            System.out.println(dis.readByte());
        }
        
        fis.close();
        
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
