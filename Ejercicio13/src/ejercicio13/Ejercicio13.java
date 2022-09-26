package ejercicio13;
import java.io.*;
import java.util.Scanner;

public class Ejercicio13 {
/*Realizar un proyecto en Java, para que nos liste los archivos y directorios
del directorio activo. El directorio activo es en el que nos encontramos
(donde está el proyecto). Para referirnos al directorio activo, lo podemos
hacer con un punto (“.”). ejercicio13.*/    
    
    public static void main(String[] args) throws IOException {
        File f = new File("./");
        String archivos [] = f.list();//Listamos el contenido en un array
        
        System.out.println("Contenido del directorio listado: ");
        for(int i=0; i<archivos.length; i++){   //Bucle for para mostrar los
            System.out.println(archivos[i]);    //directorios de la ruta actual
        }
    }
    
}
