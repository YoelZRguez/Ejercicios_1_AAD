/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio47;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
En el “proyecto47”, crear un archivo binario “fichero7.dat” a partir del “fichero31.dat”,
al que le añadimos “dni”.
Además introducimos registros hasta que la edad sea 0.
 */
public class Ejercicio47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("fichero7.dat");
        Scanner sc = new Scanner (System.in);
        f.delete();
        try {
           f.createNewFile(); 
        } catch (IOException e) {
            e.getMessage();
        }
        
        
        try {
            
                FileOutputStream fos = new FileOutputStream(f, true);
                DataOutputStream dos = new DataOutputStream(fos);  

                FileInputStream fis = new FileInputStream("../ejercicio43/fichero31.dat");
                DataInputStream dis = new DataInputStream(fis); 
                
                String nombre = dis.readUTF();
                
            while(!nombre.isEmpty()){

                int edad = dis.readInt();
                float altura = dis.readFloat();
                float peso = dis.readFloat();
                
                System.out.println("-------------------------------------------");
                System.out.println("Nombre: "+nombre);
                System.out.println("Edad: "+edad);
                System.out.println("Altura: "+altura);
                System.out.println("Peso: "+peso);
                System.out.println("Introduce un dni: ");
                String dni = sc.nextLine();
                System.out.println("--------------------------------------------");
                dos.writeUTF(dni);
                
                dos.writeUTF(nombre);
                dos.writeInt(edad);
                dos.writeFloat(altura);
                dos.writeFloat(peso);
                nombre = dis.readUTF();
                
            }
            
            
            
            
                System.out.println("Creación de perfil: ");

                int edadN;
                
            if(nombre.isEmpty()){
                do{
                    System.out.println("Introduce el nombre: ");
                    String nombreN = sc.nextLine();
                    dos.writeUTF(nombreN);
                    
                    System.out.println("Introduce una edad: ");
                    edadN = Integer.parseInt(sc.nextLine());
                    dos.writeInt(edadN);
                    
                    System.out.println("Introduce una altura: ");
                    float alturaN = Float.parseFloat(sc.nextLine());
                    dos.writeFloat(alturaN);
                    
                    System.out.println("Introduce un peso: ");
                    float pesoN = Float.parseFloat(sc.nextLine());
                    dos.writeFloat(pesoN);
                    
                }while (edadN != 0);
                
                
                
                System.out.println("Datos correctamente copiados al fichero!");
                
            }

                        
        }catch(EOFException e){
            int edadN;
        try{
            System.out.println("¡Creación de Perfil!");
            FileOutputStream fos = new FileOutputStream(f, true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            do{
                System.out.println("-------------------------------------------");
                    System.out.println("Introduce el nombre: ");
                    String nombreN = sc.nextLine();
                    dos.writeUTF(nombreN);
                    
                    System.out.println("Introduce una edad: ");
                    edadN = Integer.parseInt(sc.nextLine());
                    dos.writeInt(edadN);
                    
                    if(edadN == 0){
                        System.out.println("¡Edad no válida!");
                        dos.writeInt(edadN);
                        
                    }else{
                        
                    System.out.println("Introduce una altura: ");
                    float alturaN = Float.parseFloat(sc.nextLine());
                    dos.writeFloat(alturaN);
                    
                    System.out.println("Introduce un peso: ");
                    float pesoN = Float.parseFloat(sc.nextLine());
                    dos.writeFloat(pesoN); 
                    
                    System.out.println("Introduce un dni: ");
                    String dniN = sc.nextLine();
                    dos.writeUTF(dniN);
                    
                System.out.println("-------------------------------------------");
                    }

                }while (edadN != 0);
                
                System.out.println("Datos correctamente copiados al fichero!");
                System.out.println("Fin de Archivo");
                
                fos.close();
                dos.close();
                
        }catch(FileNotFoundException r){
            r.getMessage();
        }catch(IOException r){
            r.printStackTrace();
        }

    }catch (FileNotFoundException e) {
            
        }catch (IOException e){
            e.getMessage();
        }
    }
    
}
