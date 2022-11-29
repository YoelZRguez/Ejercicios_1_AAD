/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ev;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YoelZR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int nAtletas;
        
        System.out.println("Introduce la cantidad de participantes: ");
        nAtletas = Integer.parseInt(sc.nextLine());
        
        try{
            RandomAccessFile raf = new RandomAccessFile("ATLETAS.DAT", "rw");
            for (int i = 0; i<nAtletas; i++){
            System.out.print("Introduce el nombre del atleta: ");
            String nombre = sc.nextLine();
            
            if(nombre.length()<10){
                int espacios = 10-nombre.length();
                for (int j=0; j<espacios; j++){
                   nombre+=" "; 
                }   
            }
            raf.writeUTF(nombre);
            
            System.out.print("Introduce la edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            raf.writeInt(edad);
            
            System.out.print("Introduce la altura: ");
            float altura = Float.parseFloat(sc.nextLine());
            raf.writeFloat(altura);
            
            }
            
            raf.seek(20);
            System.out.println(raf.readUTF());
            System.out.println(raf.readInt());
            System.out.println(raf.readFloat());
            
        }catch(IOException e){
            e.getMessage();
        }
        
        
        }
    }
    
