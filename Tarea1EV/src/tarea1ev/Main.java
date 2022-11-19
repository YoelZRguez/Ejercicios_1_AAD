/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ev;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author YoelZR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <Atletas> atleta = new ArrayList<>();
        
        atleta.add(new Atletas("Luis", 25, (float) 1.89));
        atleta.add(new Atletas("Susana", 32, (float) 1.61));
        atleta.add(new Atletas("Roberto", 17, (float) 1.55));
        atleta.add(new Atletas("María", 65, (float) 1.63));
        atleta.add(new Atletas("Diego", 47, (float) 1.92));
        
        try (RandomAccessFile raf = new RandomAccessFile("ATLETAS.DAT", "rw")){
            
            
            for(Atletas i: atleta){
            
            StringBuffer sb = new StringBuffer(i.getNombre());
            sb.setLength(10);
            raf.writeChars(sb.toString());
            
            raf.writeFloat(i.getEdad());
            raf.writeFloat(i.getAltura());
                
            }
            
            raf.seek(28);
            String nombre = "";
            
            for(int i =0; i<10; i++){
                nombre+=raf.readChar();
            }
            
            System.out.println("Nombre: "+nombre);
            System.out.println("Edad: "+raf.readFloat());
            System.out.println("Altura: "+raf.readFloat());
            
            
            
            
            raf.close();
             
            
            } catch (FileNotFoundException e) {
                e.getMessage();
            
            } catch (IOException e) {
                e.getMessage();
            }
    }
    
}
