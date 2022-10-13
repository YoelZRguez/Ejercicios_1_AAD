package ejercicio22;

import java.io.*;
import java.io.IOException;

public class Ejercicio22 {
/*Crear un proyecto “ejercicio22” para contar los caracteres del fichero que creamos en la
carpeta del proyecto llamado “leer2”. Modificar el proyecto para que cuente los caracteres del
fichero “leer1”.
*/
    
    public static void main(String[] args) {
        
        try{
            FileReader f = new FileReader ("./leer22.txt");
            
            int i = 0;
            int j = 0;
            i = f.read();
            
        while(i!= -1){
            
                System.out.print((char)i);
                i=f.read();
                j++;
             
        }
            System.out.println("");
            System.out.println("Cantidad de caracteres : "+j);
        
        }catch(FileNotFoundException fnf){
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
    
