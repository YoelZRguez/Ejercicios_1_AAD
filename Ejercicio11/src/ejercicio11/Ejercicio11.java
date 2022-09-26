package ejercicio11;
import java.io.*;

public class Ejercicio11 {
/*Realizar un proyecto en Java, utilizando el IDE NetBeans en el que
creamos un archivo llamado “fichero.txt”.
El proyecto llamado ejercicio11, nos dirá si existe y si se trata de un fichero
o un directorio.*/    
    
    public static void main(String[] args) throws IOException {
        File file = new File("./fichero.txt");
        
        // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("¡Archivo de texto creado!");
            }
            else{
                System.out.println("El archivo de texto ya existe");
            }
        
        if (file.isDirectory() ){
            System.out.println("Es un directorio");
        }
        else{
            System.out.println("No es un directorio");
        }
    }
    
}
