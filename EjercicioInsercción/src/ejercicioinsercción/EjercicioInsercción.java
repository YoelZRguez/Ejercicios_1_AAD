package ejercicioinsercción;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioInsercción {
    private Scanner sc;
    private Statement sentencia;
    private Connection conexion;
    private ArrayList <String> columnas ;
    private ArrayList <String> datos ;
    PreparedStatement alumno, alumno_modulo, ciclo, profesor, modulo ;

    public EjercicioInsercción(){
        sc = new Scanner(System.in);
        columnas = new ArrayList<String> ();
        datos = new ArrayList<String> ();
            try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Se ha cargado el driver con exito");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto1","root","");
            System.out.println("Nos hemos conectado con exito");
            sentencia = conexion.createStatement();
            
            alumno = conexion.prepareStatement("INSERT INTO alumno VALUES (?,?,?,?,?)");
            alumno_modulo = conexion.prepareStatement("INSERT INTO alumno_modulo VALUES (?,?,?)");
            ciclo = conexion.prepareStatement("INSERT INTO ciclo VALUES (?,?,?)");
            profesor = conexion.prepareStatement("INSERT INTO profesor VALUES (?,?,?)");
            modulo = conexion.prepareStatement("INSERT INTO modulo VALUES (?,?,?,?,?)");

        }catch(SQLException sqle){
            sqle.getStackTrace();
        
        }catch(ClassNotFoundException cnf){
            
        }
    }
    
    private void mostrarTablas(){
       try {
            String sql = "SHOW TABLES";
            ResultSet result = sentencia.executeQuery(sql);
            System.out.println("-----------------------------------------------------");
            System.out.println("Tablas: ");
            while(result.next()){
                    System.out.println(result.getString(1));
            }
            System.out.println("-----------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Consulta no disponible");
        }
    }
    
    private String elegirTabla(){
        boolean valido = false;
        String tabla ="";
        
        do{  
        mostrarTablas();    
        System.out.println("Selecciona la tabla: ");
        System.out.print("> ");
        tabla = sc.nextLine().toLowerCase();
        
        if(tabla.equals("alumno") || tabla.equals("alumno_modulo") ||
           tabla.equals("ciclo") ||  tabla.equals("profesor") ||
           tabla.equals("modulo") || tabla.isEmpty()){
            
            valido = true;
            
        }else{
            System.out.println("¡Tabla no existente! Por favor, vuelve a introducirla.");
        }
        
        }while(!valido);
        
        return tabla;
        
        }
    
    private ArrayList<String> mostrarColumnas(String tabla){
            
        try {
            
            String sql = "SHOW COLUMNS FROM "+tabla;
            ResultSet result = sentencia.executeQuery(sql);
            System.out.println("-----------------------------------------------------");
            System.out.println("Columnas: ");
            while(result.next()){
                
                System.out.println(result.getString(1)+" ("+result.getString(2)+")");
                columnas.add(result.getString(1));
                datos.add(result.getString(2));

            }
            System.out.println("-----------------------------------------------------");
            
        } catch (SQLException ex) {
            System.out.println("Consulta no disponible");
        }
       
        return columnas;
    }
    
    private void comprobarDatos(String tabla, PreparedStatement valor){
        ArrayList <String> columna = mostrarColumnas(tabla); 
        try {
                int i = 0;
                for(String columnas1 : columna){
                    System.out.println("Introduce "+columnas1+" "+datos.get(i)+": ");
                    System.out.print("> ");
                    String dato = sc.nextLine();
                    String cadena = separarDatos(datos.get(i));
                switch(cadena){
                    case "varchar": 
                       valor.setString(i+1, dato);
                    break;
                    
                    case "int": 
                        int datoInt = Integer.parseInt(dato);
                        valor.setInt(i+1, datoInt);
                        
                    break;
                    
                    case "date":
                        Date date = Date.valueOf(dato);
                        valor.setDate(i+1, date);
                    break;
                }
                i++;
                }
                valor.executeUpdate();
        }catch(SQLException ex){
            System.out.println("No se puede realizar la consulta");
    }
        
    }
    
    private String separarDatos(String cadena){
        String vocablo ="";
        if(cadena.compareTo("date") == 0){
            vocablo ="date";
        }else if(cadena.contains("varchar")){
            vocablo = "varchar";
        }else if(cadena.contains("int")){
            vocablo = "int";
        }
        return vocablo;
    }
    
    
    private void insertarDatos (String tabla){

        switch(tabla){
            case "alumno":
                comprobarDatos(tabla, alumno);
                break;
                
            case "alumno_modulo":
                comprobarDatos(tabla, alumno_modulo);
                break;
                
            case "ciclo":
                comprobarDatos(tabla, ciclo);
                break;
                
            case "modulo":
                comprobarDatos(tabla, modulo);
                break;
                
            case "profesor":
                comprobarDatos(tabla, profesor);
                break;
                
        }
    }
    
    public void iniciarPrograma(){
        String tabla ="";
        do{
        tabla = elegirTabla();
        insertarDatos(tabla);
        }while(!tabla.isEmpty());
    }
    
        
    public static void main(String[] args) {
        EjercicioInsercción ej = new EjercicioInsercción();
        ej.iniciarPrograma();
    }  
}
