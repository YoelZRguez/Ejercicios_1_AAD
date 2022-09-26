package ejercicio17;
import java.io.*;

public class Ejercicio17 {

/*Crear un directorio “directorio17”, en él crear un archivo “fichero17”.*/  
    
    public static void main(String[] args) {
        File directorio = new File ("./directorio17");
        File archivo = new File ("./directorio17/archivo17.txt");
       
        try{
            directorio.mkdir();
            System.out.println("Directorio creado");
            archivo.createNewFile();
            System.out.println("Txt creado");
            
        }catch(IOException e){
        
        }
        
        
    }
    
}
