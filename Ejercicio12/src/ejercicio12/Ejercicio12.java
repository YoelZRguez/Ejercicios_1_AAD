package ejercicio12;
import java.io.*;
import java.util.Scanner;

public class Ejercicio12 {
/*Realizar un proyecto en Java, en el que creamos un fichero cuyo nombre
introducimos por teclado y el programa nos dice si el archivo es de lectura
y/o de escritura. Proyecto ejercicio12.*/    
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        String nombre;
        
        
        System.out.println("Introduzca el nombre del archivo: ");
        nombre = sc.nextLine();
        
        File file = new File("./"+nombre+".txt");
        
        // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("¡Archivo de texto creado!");
            }
            else{
                System.out.println("El archivo de texto ya existe");
            }
        
        if (file.canRead() && file.canWrite()){
            System.out.println("Archivo de lectura y escritura");
        }
        else if(file.canWrite() && !file.canRead()){
            System.out.println("Archivo de escritura");
        }
        else if(file.canRead() && !file.canWrite()){
            System.out.println("Archivo de lectura");
        }
        else{
            System.out.println("Este archivo no es de lectura ni de escritura");
        }
    }
    
}
