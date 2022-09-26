
package ejercicio16;
import java.io.*;

public class Ejercicio16 {

/*En el ejercicio16, renombrar el “fichero.txt” por “fichero16.txt”*/  
    
    public static void main(String[] args) {
        File file = new File ("../Ejercicio11/fichero.txt");
        File file2 = new File ("../Ejercicio11/fichero16.txt");
       
        
        file.renameTo(file2);
            System.out.println("Nombre de archivo de texto cambiado a fichero16.txt");
        }
    }
    

