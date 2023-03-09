
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Crear_XML {
    Scanner sc = new Scanner(System.in);
    private static Element hijo;
    
    public static void main(String [] args){
        try {
        String elementoPadre;
        boolean sigo;
        System.out.println("Bienvenido a la creación de un archivo XML!");
        Crear_XML xml = new Crear_XML();
        
        elementoPadre = xml.elementoPadre();
        Element padre = new Element(elementoPadre);
        Document documento = new Document(padre);
        
        do{
        hijo = xml.campoPricipal(hijo, padre);
        sigo = xml.sigo();
        }while(sigo);
        
        System.out.println("Finalizando el programa! ");
        XMLOutputter xml1 = new XMLOutputter();
        xml1.setFormat(Format.getPrettyFormat());
        xml1.output(documento, new FileWriter("JDOM_CrearXML_Recursivo.xml"));
        } catch (IOException ex) {
            Logger.getLogger(Crear_XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean sigo(){
        boolean sigo = false;
        String respuesta = "";
        do{
        System.out.print("¿Deseas seguir?(y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        if(respuesta.toLowerCase().compareTo("y") == 0){
            sigo = true;
        }
        return sigo;
    }
    
    private String elementoPadre(){
        String padre="";
        System.out.print("Introduce el valor del elemento padre: ");
        padre = sc.nextLine();
        return padre;
    }
    
    private Element campoPricipal(Element elemento, Element padre){
        String respuesta ="";
        do{
        System.out.print("¿Deseas añadir un campo hijo del principal?(y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        if (respuesta.toLowerCase().compareTo("y") == 0){
            elemento = pedirCampoMismoNivel();
            elemento = añadirAtributos(elemento);
            padre.addContent(elemento);
            padre = elemento;
            elemento = seguirHijo(elemento, padre);
        }
        
        return elemento;
    }
    
    private Element añadirAtributos(Element elemento){
        String respuesta="", nombre="",campo="";
        do{
        System.out.print("¿Deseas añadir atributos? (y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        if (respuesta.toLowerCase().compareTo("y")==0){
            System.out.print("Introduce el nombre del atributo: ");
            nombre = sc.nextLine();
            System.out.print("Introduce el valor del atributo: ");
            campo = sc.nextLine();
            elemento.setAttribute(nombre,campo);
        }        
        return elemento;
    }
    
    
    private Element seguirHijo(Element objeto, Element padre){
        String respuesta="";
        do{
        System.out.print("¿Deseas añadir elemento hijo? (y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        if(respuesta.toLowerCase().compareTo("y") == 0){
            objeto = pedirCampoHijo();
            objeto = añadirAtributos(objeto);
            padre.addContent(objeto);
            objeto = seguirNivel(objeto, padre);
        }
        return objeto;
    }
    
    private Element seguirNivel(Element objeto, Element padre){
        String respuesta="";
        do{
        System.out.print("¿Deseas añadir otro elemento al mismo nivel? (y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        if(respuesta.toLowerCase().compareTo("y") == 0){
            objeto = pedirCampoMismoNivel();
            objeto = añadirAtributos(objeto);
            padre.addContent(objeto);
            objeto = seguirNivel(objeto, padre);
        }else{
            padre = objeto;
            objeto = seguirHijo(objeto, padre);
        }
        
        return objeto;
    }
    
    private Element añadirValor(Element elemento){
        String valor="", respuesta="";
        do{
        System.out.print("¿Deseas introducir un valor para el elemento? (y/n): ");
        respuesta = sc.nextLine();
        }while(respuesta.toLowerCase().compareTo("y") != 0 && respuesta.toLowerCase().compareTo("n") != 0);
        
        
        if(respuesta.toLowerCase().compareTo("y") == 0){
            System.out.print("Introduce un valor para el elemento: ");
            valor = sc.nextLine();
            elemento.setText(valor);
        }
        return elemento;
    }
    
    private Element pedirCampoMismoNivel(){
        System.out.print("Introduce el nombre del elemento: ");
        String campo = sc.nextLine();
        Element elemento = new Element(campo);
        
        elemento = añadirValor(elemento);
        
        return elemento;
    }

    private Element pedirCampoHijo(){
        System.out.print("Introduce el nombre del elemento hijo: ");
        String campo = sc.nextLine();
        Element elemento = new Element(campo);
        
        elemento = añadirValor(elemento);
        return elemento;
    }
    
}
