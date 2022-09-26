
package ejercicio15;
import java.io.*;
import java.text.SimpleDateFormat;

public class Ejercicio15 {
/*En el ejercicio15, mostrar el número de segundos transcurridos desde
1970 (java toma ese año como referencia) de la última modificación del
archivo “fichero.txt” del ejercicio 1. Mostrar la fecha de la última
modificación de ese archivo. .*/    
    
    public static void main(String[] args) throws IOException {
        File file = new File("../Ejercicio11/fichero.txt");
        SimpleDateFormat objeto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Última modificación: "+objeto.format(file.lastModified()));
        
        
        
        
        
        
            
    }
    
}
