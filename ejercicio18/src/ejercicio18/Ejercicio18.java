
package ejercicio18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author yoelzr
 */
public class Ejercicio18 {

/**
Crear un directorio “directorio18”, en él crear un archivo “fichero18”.
Mostrar si existen y si son archivos o directorios.
Del archivo mostrar:
* - si es de lectura,
- si es de escritura,
- la fecha de la última modificación,
- renombrarlo,
- listar el contenido del directorio,
- el nombre,
- la ruta,
-el tamaño.
Finalmente preguntamos si queremos borrarlo y si respondemos si, lo
borrará.
*/
    
    public static void main(String[] args) {
        File directorio = new File ("./directorio18");
        File archivo = new File ("./directorio18/archivo18.txt");
        File archivo2 = new File ("./drectorio18/archivo18-1.txt");
        SimpleDateFormat objeto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
       archivo2.renameTo(archivo);
       
        try{
            if(!directorio.exists()){
            directorio.mkdir();
            System.out.println("Directorio creado");
            
            }else{
                System.out.println("El directorio ya existe");
            }
            
            
            if(!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Txt creado");
            
            }else{
                System.out.println("El archivo ya existe");
            }
            
            }catch(IOException e){
                
                
            }
            
     System.out.println("-----------------------------------------------------");
            
        if (archivo.canRead() && archivo.canWrite()){
            System.out.println("El archivo es de lectura y escritura");
        }
        
        else if (archivo.canRead() && !archivo.canWrite()){
            System.out.println("Archivo de lectura");
        }
        
        else if(!archivo.canRead() && archivo.canWrite()){
            System.out.println("Archivo de escritura");    
        }
           
        else{
            System.out.println("No es archivo de lectura ni escritura");
                    }
        System.out.println("-----------------------------------------------------");
        
        System.out.println("Última modificación: "+objeto.format(archivo.lastModified()));
        
        System.out.println("-----------------------------------------------------");
        
        archivo.renameTo(archivo2);
            System.out.println("Nuevo nombre de archivo");
            System.out.println("Fichero18-1.txt");
            
        System.out.println("-----------------------------------------------------");
        
        String tDirectorio [] = directorio.list();
            System.out.println("Contenido del directorio : ");
        for (int i=0; i<directorio.length(); i++){
            System.out.println(tDirectorio[i]);
        }
        
        System.out.println("-----------------------------------------------------");
        
            System.out.println("El nombre del directorio es "+directorio.getName());
            
        System.out.println("-----------------------------------------------------");
        
            System.out.println("La ruta del directorio es "+directorio.getAbsolutePath());
            
        System.out.println("-----------------------------------------------------");
        
            System.out.println("El tamaño del directorio es "+directorio.length()+" bytes");
        
        System.out.println("-----------------------------------------------------");
        
        
        String borrar;  
        
        do{
        borrar = JOptionPane.showInputDialog(null, "¿Desea borrar el archivo? (s/n)");
        if (borrar.compareTo("s") == 0  ||  borrar.compareTo("S") == 0){
            archivo.delete();
        JOptionPane.showMessageDialog(null, "Archivo borrado");
        }
        else if(borrar.compareTo("n") == 0 || borrar.compareTo("N") == 0){
            JOptionPane.showMessageDialog(null, "No se ha borrado el archivo");
        }
        else{
            JOptionPane.showMessageDialog(null, "Introduzca s/n (si/no) para confirmar");
        }
        }while(borrar.compareTo("s") != 0 && borrar.compareTo("S") != 0 
         && borrar.compareTo("n") != 0 && borrar.compareTo("N") != 0);
        
        
        do{
        borrar = JOptionPane.showInputDialog(null, "¿Desea borrar el directorio? (s/n)");
        if (borrar.compareTo("s") == 0 || borrar.compareTo("S") == 0){
            archivo.delete();
            directorio.delete();
            JOptionPane.showMessageDialog(null, "Directorio borrado");
        }
        else if(borrar.compareTo("n") == 0 || borrar.compareTo("N") == 0){
            JOptionPane.showMessageDialog(null, "No se ha borrado el directorio");
        }
        else{
            JOptionPane.showMessageDialog(null, "Introduzca s/n (si/no) para confirmar");
        }
        
        }while(borrar.compareTo("s") != 0 && borrar.compareTo("S") != 0 
         && borrar.compareTo("n") != 0 && borrar.compareTo("N") != 0);
        
        
        
        
        
            
            }
    
}
