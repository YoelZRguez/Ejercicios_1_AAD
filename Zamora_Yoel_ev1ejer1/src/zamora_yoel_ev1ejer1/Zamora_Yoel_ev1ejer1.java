/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zamora_yoel_ev1ejer1;

import java.io.*;

public class Zamora_Yoel_ev1ejer1 {

    
    public static void main(String[] args) {
        try { 
            int contador = 0;
            BufferedReader br = new BufferedReader(new FileReader("iniciales.txt"));
            int leer = br.read();
            int letraAnterior = 0;
            
            
            while(leer!=-1){
                if(leer==65 || leer==97){
                    
                    if(letraAnterior==10 || letraAnterior==32){
                    contador++;
                    }else if(letraAnterior == 0){
                    contador++;
                    }
               }
                
                letraAnterior = leer;
                leer = br.read();
            }
            
            System.out.println("Existen un total de "+contador+" palabras que empiezan con la letra A/a");
            System.out.println("¡Fin del programa!");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error Fnf");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    
}
