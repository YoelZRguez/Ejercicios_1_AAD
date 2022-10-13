package ejercicio21;

import java.io.*;
import java.io.IOException;

public class Ejercicio21 {
/*Crear un fichero con la opción documento de texto dentro de nuevo en el menú
desplegable de nuestra carpeta donde creamos el proyecto para leer ese fichero. El proyecto
lo llamaremos “ejercicio21”. Al fichero lo llamamos “leer1” , Windows nos pondrá la extensión
.txt. El fichero que estamos leyendo, lo sacamos por pantalla.
*/
    
    public static void main(String[] args) {
        
        try{
            FileReader f = new FileReader ("./leer21.txt");
            
            int i = 0;
            i = f.read();
            
        while(i!= -1){
            
                System.out.print((char)i);
                i=f.read();
                
             
        }
            System.out.println("");
            
        
        }catch(FileNotFoundException fnf){
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
    

