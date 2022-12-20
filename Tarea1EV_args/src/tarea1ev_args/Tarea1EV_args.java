/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ev_args;


import java.io.IOException;
import java.io.RandomAccessFile;


/**
 *
 * @author yoelzr
 */
public class Tarea1EV_args {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        
        try(RandomAccessFile raf = new RandomAccessFile ("../ATLETAS.DAT", "rw")){
            
            
            for(int i = 0; i<args.length;i++){
                
                
                int posicion = Integer.parseInt(args[i]);
                raf.seek((posicion-1) *28);
                
                    String nombre="";
                    for (int j = 0; j < 10; j++) {
                       nombre+= raf.readChar();
                    }
                    
                    int edad = raf.readInt();
                    float altura = raf.readFloat();
                    
                    System.out.print(nombre);
                    System.out.print("\t"+edad);
                    System.out.println("\t"+altura);
                
                
            }
            
        } catch (IOException ex) {
            ex.getMessage();
        }
        
    }
    
}
