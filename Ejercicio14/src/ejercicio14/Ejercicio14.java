package ejercicio14;
import java.io.*;
import java.util.Scanner;

public class Ejercicio14 {
/*Realizar un proyecto que nos muestre el número de bytes que contiene
un fichero que hemos creado en nuestro directorio con botón derecho del
ratón, nuevo, archivo de texto. A continuación borrar el fichero.*/    
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        
        
        System.out.println("Comprobando los bytes del archivo...");
        
        
        File file = new File("./fichero14.txt");
        
        System.out.println(file.length()+" bytes");
        file.delete();
        
        
            
    }
    
}
