package ejercicio45;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio45 {
    
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        try {
            String cad = "";
            String firma;
            boolean aux = false;
            FileOutputStream fic = new FileOutputStream("fichero.dat", true);
            DataOutputStream f1 = new DataOutputStream(fic);
            
            int numero = 0;
            do {
                System.out.println("---------------");
                System.out.println("1-Introducir nombre");
                System.out.println("2-Listar nombres");
                System.out.println("3-Salir");
                System.out.println("---------------");
                numero = Integer.parseInt(tec.nextLine());
                switch (numero) {
                    case 1:
                        FileInputStream ficrepe = new FileInputStream("fichero.dat");
                        DataInputStream firepe = new DataInputStream(ficrepe);
                        System.out.println("Escibe nombre");
                        cad = tec.nextLine();
                        boolean repe = false;                        
                        
                        try {
                            while (true) {
                                if (cad.equals(firepe.readUTF())) {
                                    repe = true;
                                }
                                if (repe) {
                                    
                                }
                            }
                            
                        } catch (EOFException e) {
                        }                        
                        
                        if (!repe) {
                            f1.writeUTF(cad);
                        } else {
                            System.out.println("Nombre repetido");
                        }
                        ficrepe.close();
                        firepe.close();
                        break;
                    
                    case 2:
                        FileInputStream ficleer = new FileInputStream("fichero.dat");
                        DataInputStream file = new DataInputStream(ficleer);
                        boolean seguir = true;
                        try {
                            System.out.println("Listas de nombres: ");                            
                            
                            while (seguir) {
                                for (int i = 0; i < 24; i++) {
                                    System.out.println(file.readUTF());                                    
                                }
                                System.out.println("Quieres mostrar mas? (si/no)");
                                String cadena = tec.nextLine();
                                if (cadena.toLowerCase().equals("no")) {
                                    seguir = false;
                                }
                            }
                            
                        } catch (EOFException e) {
                            System.out.println();                            
                            System.out.println("Fin de fichero");
                        }                        
                        
                        ficleer.close();
                        file.close();
                        break;
                }
                
            } while (numero != 3);
            f1.close();
            fic.close();            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio45.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio45.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}
