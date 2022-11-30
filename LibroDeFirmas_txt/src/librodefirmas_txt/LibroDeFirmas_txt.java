/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librodefirmas_txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YoelZR
 */
public class LibroDeFirmas_txt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String firma ;
        
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("libroFirmas.txt", true));
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error I/O");
        }
            System.out.println("Introduce un nombre para firmar: ");
            firma = sc.nextLine();
        try{  
            while(firma.length() > 0){
                
            BufferedReader br = new BufferedReader(new FileReader("libroFirmas.txt"));
            boolean encontrado = false;
            String comprobar = br.readLine();
            
            while(comprobar!=null){
                if(firma==null){
                    
                    break;
                }
                else if(firma.equals(comprobar)){
                    encontrado = true;
                }
                comprobar = br.readLine();
            }
            
            if(encontrado){
                System.out.println("Nombre repetido!");
            }else if(!encontrado || firma == null){
                System.out.println(firma+" no aparece, se grabará a continuación!");
                BufferedWriter bw = new BufferedWriter(new FileWriter("libroFirmas.txt"));
                
                bw.write(firma);
                bw.newLine();
                bw.close();
            }
            br.close();
            
            System.out.println("Introduce un nombre para firmar: ");
            firma = sc.nextLine();
                
            }
        }catch(IOException e){
            System.out.println("Error I/O");
        }
            
        
    }
    
}
