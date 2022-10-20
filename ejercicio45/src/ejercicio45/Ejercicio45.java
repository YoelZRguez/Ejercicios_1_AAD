/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio45;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
      ArrayList <String> nombres = new ArrayList<String>();
      
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
            
    try{
        
        FileOutputStream fos = new FileOutputStream ("firmas.dat");
        DataOutputStream dos = new DataOutputStream(fos);
        FileInputStream fos2 = new FileInputStream ("firmas.dat");
        DataInputStream dos2 = new DataInputStream(fos2);
        
        System.out.print("Introduce el nombre para firmar: ");
        String nombre = sc.nextLine().toUpperCase();
        
        if(contador == 0){
                dos.writeUTF(nombre);
                contador++;
                nombres.add(nombre);
     
        }else{
            for (int i = 0; i<nombres.size(); i++){
                if (nombres.get(i).matches(nombre)){
                    System.out.println("Ya se ha firmado con este nombre!");
                }else{
                    nombres.add(nombre);
                    dos.writeUTF(nombre);
                }
            
        }
            
        }
        
        fos.close();
        dos.close();
        fos2.close();
        dos2.close();
        
      }catch(EOFException e){
          System.out.println("Ya se ha firmado con este nombre");
      }catch(FileNotFoundException e){
          e.printStackTrace();
      }catch(IOException e){
          e.printStackTrace();
      }

        break;
            
        case 2:
        try{  
        int numeroLineas = 24;
        
        FileInputStream fos2 = new FileInputStream ("firmas.dat");
        DataInputStream dos2 = new DataInputStream(fos2);
            System.out.println("Introduce el numero de lineas a mostrar por pantalla: ");
            numeroLineas = Integer.parseInt(sc.nextLine());
            
            
        for (int i = 0; i<nombres.size(); i++){
            if(i != numeroLineas){
                System.out.println(nombres.get(i));

            }
        }
            fos2.close();
            dos2.close();           
            
        
        

      }catch(EOFException e){
          e.printStackTrace();
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