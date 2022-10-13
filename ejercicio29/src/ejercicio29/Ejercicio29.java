/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio29;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
En el proyecto “ejercicio29”, mostrar por pantalla las líneas leídas en el fichero
“leer9” y mostrar el número de orden que ocupan.
Finalmente indicar que línea es la más larga y con cuántos caracteres.
 */
public class Ejercicio29 {

    
    public static void main(String[] args) {
    int contador = 0;
    int i = 1;
        try{
           BufferedReader bf = new BufferedReader( new FileReader ("./leer29.txt"));
           String texto = bf.readLine();
           String textoMasChar = texto;
           while (texto != null){
           
            contador ++;
            System.out.println(i+". "+texto);
            i++;
            
            if(textoMasChar.length() < texto.length()){
            textoMasChar = texto;
            }
            
            texto = bf.readLine();
            
               }
           bf.close();
           
            System.out.println("");
            System.out.println("La linea mas larga del archivo de texto es: "+textoMasChar);
            System.out.println("El numero de caracteres de esta linea es: "+textoMasChar.length());
            
        }catch (FileNotFoundException fnf){
        
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
