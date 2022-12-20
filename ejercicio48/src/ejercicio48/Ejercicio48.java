/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio48;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author yoelzr
 */
public class Ejercicio48 {

    /**
    Leer el archivo anterior “fichero7.dat” para comprobar que están bien los datos introducidos.
     */
    public static void main(String[] args) {        
        
        try{
            
            FileInputStream fis = new FileInputStream("../ejercicio47/fichero7.dat");
            DataInputStream dis = new DataInputStream(fis);
            String nombre = dis.readUTF();
            int edad = dis.readInt();
            float altura = dis.readFloat();
            float peso = dis.readFloat();
            String dni = dis.readUTF();
            
            
            while(edad != 0){

                System.out.println("Nombre: "
                        + "\t\tEdad: "
                        + "\t\tAltura: "
                        + "\t\tPeso: "
                        + "\t\tDni: ");
                
                     
                
                    System.out.println(nombre+""
                            + "\t\t\t"+edad+""
                            + "\t\t"+altura+""
                            + "\t\t\t"+peso+""
                            + "\t\t"+dni);
                    
                    nombre = dis.readUTF();
                    edad = dis.readInt();
                    altura = dis.readFloat();
                    peso = dis.readFloat();
                    dni = dis.readUTF();
                
            }
            
        
        
        }catch(FileNotFoundException fnf){
            fnf.getMessage();

        }catch(IOException e){
            e.getMessage();
        
        
    }
        
    }
    
}
    
    

