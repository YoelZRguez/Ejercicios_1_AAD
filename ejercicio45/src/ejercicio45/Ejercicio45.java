/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio45;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
Un libro de firmas es útil para recoger todas las personas que han pasado por un
determinado lugar. Crear una aplicación que permita mostrar el libro de firmas o
insertar un nuevo nombre (comprobando que no se encuentra repetido). Llamaremos
al fichero “firmas.dat”. Implementar que el programa funcione de forma similar al
comando more de Linux, al que se le pasa un fichero y lo muestra poco a poco, cada
24 líneas, pero que también sea posible indicar cuantas líneas se muestran de cada
vez. “Proyecto45”
 */
public class Ejercicio45 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
     Scanner sc = new Scanner (System.in);
      int opcion;
      int contador = 0;
      File f = new File ("firmas.dat");
      f.delete();
      
      try{
          f.createNewFile();
      }catch(IOException e){
          e.printStackTrace();
      }

      
      
      do{
          System.out.println("------------------------------------------------");
          System.out.println("Introduce la opción que deseas: "
                  + "\n1. Escribir nombre: "
                  + "\n2. Mostrar libro de firmas: "
                  + "\n0. Salir");
          System.out.println("------------------------------------------------");
          opcion = Integer.parseInt(sc.nextLine());
          
    switch(opcion){
        case 1: 
            boolean repe = false;
            String nombre = "";
            
        try{
        FileOutputStream fos = new FileOutputStream (f, true);
        DataOutputStream dos = new DataOutputStream(fos);
        FileInputStream fis = new FileInputStream (f);
        DataInputStream dis = new DataInputStream(fis);

            System.out.println("Introduzca el nombre para firmar: ");
            nombre = sc.nextLine().toUpperCase();
            
            try{
               for(int i=0; i<dis.available(); i++){
                    if(nombre.equals(dis.readUTF())){
                    repe = true;
                    System.out.println("Nombre repetido");
                    break;
                 }
               }
            }catch(EOFException e){
            System.out.println("Final del archivo!");
            }
 
               
        
        if(repe == false){
            dos.writeUTF(nombre);
            System.out.println("Nombre escrito con éxito!");
        }
        fos.close();
        dos.close();
        fis.close();
        dis.close();
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
      

        break;
            
        case 2:
            try{
            
            FileInputStream fis = new FileInputStream (f);
            DataInputStream dis = new DataInputStream(fis);
            
                System.out.println("¿Cuántas líneas de código quieres?");
                int lineas = Integer.parseInt(sc.nextLine());
                try{
                   for(int i = 0;i<lineas; i++ ){
                    String nombreLeido = dis.readUTF();
                    System.out.println(nombreLeido);
                } 
                }catch(EOFException e){
                    System.out.println("No existen más nombres!");
                }
                
            
            }catch(FileNotFoundException fnf){
                fnf.getStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        break;
            
        case 0: 
            System.out.println("Saliendo del programa...");
            break;
            
        default: 
            System.out.println("Opción no válida!");
        break;
    }
        
      }while(opcion != 0);
      
      }
          
      

   }



