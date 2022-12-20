
package zamorarodriguezyoel_tarea2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZamoraRodriguezYoel_tarea2 {
    private Scanner sc = new Scanner(System.in);
    private Statement sentencia;
    private Connection conexion;
    

    public ZamoraRodriguezYoel_tarea2() {
        try{
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver SQLite cargado");
            conexion = DriverManager.getConnection
            ("jdbc:sqlite:instituto3.db");
            System.out.println("Conexión realizada con éxito con Instituto 3");
            sentencia = conexion.createStatement();

        }catch(ClassNotFoundException cnfe){
            cnfe.getStackTrace();
        
         }catch(SQLException sqle){
            sqle.getStackTrace();
        }
    }
    
    public static void main(String[] args) {
         ZamoraRodriguezYoel_tarea2 zry = new ZamoraRodriguezYoel_tarea2();
         zry.iniciarPrograma();
        
    }
    
    private void filtrarColumnas(String sql, String[] columna){
         try{
           ResultSet resul = sentencia.executeQuery(sql);
            while(resul.next()){
                for(int i = 1; i<=columna.length; i++){
                    System.out.print(resul.getString(i)+" ");
                    
                if(i == columna.length){
                    System.out.println("");
                }
                
                }
            }
            
         }catch(SQLException sqle){
            sqle.getStackTrace();
        }
    }
    
    private void iniciarPrograma(){
        int opcion;
        
        do{
          opcion = menu();
          eleccionMenu(opcion);
        }while(opcion!=0);
        
    }
    
    private int menu(){
        System.out.println("-----------------------------------------------------");
        System.out.println("Introduce la opción que quiere realizar: "
                + "\n1. Listar"
                + "\n2. Inserción"
                + "\n3. Modificación"
                + "\n4. Borrado"
                + "\n0. Salir");
        System.out.println("-----------------------------------------------------");
        System.out.print("> ");
        int opcion = Integer.parseInt(sc.nextLine());
        
        return opcion;
    }

    private void eleccionMenu(int opcion){
            String tabla;
            switch(opcion){
                case 1: 
                    tabla = elegirTabla();
                    listar(tabla);
                    break;
                    
                case 2: 
                    tabla = elegirTabla();
                    insertar(tabla);
                    break;
                    
                case 3: 
                    tabla = elegirTabla();
                    modificar(tabla);
                    break;
                    
                case 4: 
                    tabla = elegirTabla();
                    borrar(tabla);
                    break;
                    
                case 0:
                    System.out.println("Finalizando el programa...");
            
                try {
                    sentencia.close();
                    conexion.close();
                } catch (SQLException ex) {
                    System.out.println("No se puede finalizar la conexión");
                }
                System.out.println("Conexión finalizada con Instituto3");
            
                    break;
                    
                default:
                    System.out.println("!Opción no válida!");
                    break;
            }
        }

    private void mostrarTablas(){
        try {
            String sql = "SELECT name FROM sqlite_master WHERE type = 'table' ORDER BY name;";
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
           tabla.equals("modulo")){
            
            valido = true;
            
        }else{
            System.out.println("¡Tabla no existente! Por favor, vuelve a introducirla.");
        }
        
        }while(!valido);
        
        return tabla;
        
        }
    
    private String mostrarColumnas(String tabla, String resultado){
        try {
            
            String sql = "SELECT name FROM PRAGMA_TABLE_INFO('"+tabla+"');";
            ResultSet result = sentencia.executeQuery(sql);
            System.out.println("-----------------------------------------------------");
            System.out.println("Columnas: ");
            while(result.next()){
                resultado += result.getString(1)+",";
                System.out.println(result.getString(1));
            }
            System.out.println("-----------------------------------------------------");
            
        } catch (SQLException ex) {
            System.out.println("Consulta no disponible");
        }
        
        return resultado;
    }
    
    private String pedirColumnasListar(String tabla){
        String guardadas="";
        String columnasTotales="";
        String insertar="";
        boolean valido = false;
        boolean seguir = false;
        guardadas = mostrarColumnas(tabla, guardadas);
        String guardar[] = guardadas.split(",");
        String columnas ="";
        
        do{
        System.out.println("Introduce la columna que quieras consultar ((*) para todo): ");
        System.out.print("> ");
        columnas = sc.nextLine();
        
            for (int i = 0; i < guardar.length; i++) {
                if(columnas.compareTo(guardar[i])==0){
                    valido=true;
                    columnasTotales+=columnas;
                    break;
                    
                }else if(columnas.equals("*")){
                    columnasTotales="*";
                    seguir = false;
                    valido = true;        
                    break;
                    
                } else{
                    valido = false;
                }
            }
                if(!valido){
                System.out.println("Valor no válido");
            }
                
            if(!columnas.equals("*")){
                do{
                  System.out.println("¿Desea insertar más columnas? (s/n)");
                  System.out.print("> ");
                  insertar=sc.nextLine().toLowerCase();
            
                if(insertar.compareTo("s") == 0){
                    seguir = true;
                    
                }else if((insertar.compareTo("n") == 0)){
                    seguir = false;
                    
                }else{
                System.out.println("Valor no válido");
                }
                
                if(seguir){
                columnasTotales+=",";    
                }
                
            }while(insertar.compareTo("n") != 0
                  && (insertar.compareTo("s") != 0));   
            }
        }while(seguir);
        
       return columnasTotales;
    }
    
    private void listar(String tabla){
        String sql;
        String columnas="";
        columnas = pedirColumnasListar(tabla);
        
        if(columnas.isEmpty()){
            System.out.println("¡No se puede realizar la consulta!");
            
        }else{
            if(columnas.equals("*")){
                sql = "SELECT * FROM "+tabla+"";
            
                if(tabla.equals("modulo") || tabla.equals("alumno")){
                String [] columnas5 = {"1", "2", "3", "4", "5"};
                filtrarColumnas(sql, columnas5);
                
                }else{
                String columnas3[] = {"1", "2", "3"};
                filtrarColumnas(sql, columnas3);
                }
            
            }else{
            String columSelect[]= columnas.split(",");
            
            sql = "SELECT "+columnas+" FROM "+tabla;
            filtrarColumnas(sql, columSelect);        
        }
        }
    }

    private void consultasUpdate(String sql){
        try{
           sentencia.executeUpdate(sql);
            System.out.println("Datos actualizados!");
         }catch(SQLException sqle){
            System.out.println("No se ha podido realizar la consulta");
        }
    }
    
    private void insertando5Columnas(String tabla){
        String sql;
        String columnas="";
        columnas = mostrarColumnas(tabla, columnas);
        String columnasG[] = columnas.split(",");
        String valores[] = new String [columnasG.length];
        for(int i=0;i<5;i++){
                System.out.print("Introduce "+columnasG[i]+": ");
                valores[i] = sc.nextLine();
                }
            sql = "INSERT INTO "+tabla+""
            + " ("+columnasG[0]+", "+columnasG[1]+", "+columnasG[2]+", "+columnasG[3]+", "+columnasG[4]+")"
            + " VALUES ('"+valores[0]+"', '"+valores[1]+"', '"+valores[2]+"', '"+valores[3]+"', '"+valores[4]+"')";
                consultasUpdate(sql);
    }
    
    private void insertando3Columnas(String tabla){
        String sql;
        String columnas="";
        columnas = mostrarColumnas(tabla, columnas);
        String columnasG[] = columnas.split(",");
        String valores[] = new String [columnasG.length];
        
        for(int i=0;i<3;i++){
                System.out.print("Introduce "+columnasG[i]+": ");
                valores[i] = sc.nextLine();
                }
            sql = "INSERT INTO "+tabla+""
            + " ("+columnasG[0]+", "+columnasG[1]+", "+columnasG[2]+")"
            + " VALUES ('"+valores[0]+"', '"+valores[1]+"', '"+valores[2]+"')";
                consultasUpdate(sql);
    }
    
    private void insertar(String tabla){
        switch(tabla){
            case "alumno": 
                insertando5Columnas(tabla);
                break;
        
            case "alumno_modulo": 
                System.out.println("No se pueden insertar datos en esta tabla");
                break;    
            
            case "ciclo": 
                insertando3Columnas(tabla);
                break;
                
            case "modulo": 
                insertando5Columnas(tabla);
                break;

            case "profesor": 
                insertando3Columnas(tabla);
                break;
                
        }
    }
    
    private void modificarColumna(String tabla){
        String sql;
        String columnas="", columna="";
        boolean valido=false;
        columnas = mostrarColumnas(tabla, columnas);
        String columnasG[] = columnas.split(",");
        
        System.out.println("Introduce "+columnasG[0]+" de la tabla "+tabla+" que deseas actualizar ");
        System.out.print("> ");
        String codigo = sc.nextLine();
        
        do{
        System.out.println("Introduce la columna que deseas modificar ");
        System.out.print("> ");
        columna = sc.nextLine();
        
        for (int i = 0; i < columnasG.length; i++) {
            if(columna.equals(columnasG[i])){
                valido = true;
                break;
            }
        }
            if(!valido){
                System.out.println("Valor no válido, vuelva a introducirlo");
            }
        }while(!valido);
        
        System.out.println("Introduce un nuevo valor");
        System.out.print("> ");
        String valor = sc.nextLine();
        
        sql = "UPDATE "+tabla+" set "+columna+"='"+valor+"' WHERE "+columnasG[0]+"='"+codigo+"'";
        consultasUpdate(sql);
        
    }
    
    private void modificar(String tabla){
        String columnas ="";
        switch(tabla){
            case "alumno": 
                modificarColumna(tabla);
                break;
        
            case "alumno_modulo": 
                columnas = mostrarColumnas(tabla, columnas);
                String columnasG[] = columnas.split(",");
                System.out.println("¡SOLO SE PUEDE MODIFICAR LA NOTA!");
                System.out.println("Introduce "+columnasG[0]+" para la nota que deseas modificar");
                System.out.print("> ");
                String codigoAlumno = sc.nextLine();
                System.out.println("Introduce "+columnasG[1]+" para la nota que deseas modificar");
                System.out.print("> ");
                String codigoModulo = sc.nextLine();
                System.out.println("Introduce un nuevo valor de la nota");
                System.out.print("> ");
                String nota = sc.nextLine();
                String sql = "UPDATE "+tabla+" set nota='"+nota+"' WHERE "+columnasG[0]+"='"+codigoAlumno+"' AND "+columnasG[1]+"='"+codigoModulo+"'";
                consultasUpdate(sql);
                break;    
            
            case "ciclo": 
                modificarColumna(tabla);
                break;
                
            case "profesor": 
                modificarColumna(tabla);
                break;
                
            case "modulo": 
                modificarColumna(tabla);
                break;
        }
    }
    
    private void mostrarAlumno(String tabla, String codigo, String cod_introducido){
        try {
            String sql = "SELECT * FROM "+tabla+" WHERE "+codigo+"='"+cod_introducido+"';";
            ResultSet result = sentencia.executeQuery(sql);
            System.out.println("-----------------------------------------------------");
            while(result.next()){
                if(tabla.compareTo("modulo") == 0 ||tabla.compareTo("alumno") == 0){
                    for(int i=1; i<=5;i++){
                        System.out.print(result.getString(i)+"  ");
                        }
                    System.out.println("");
                }else{
                    for(int i=1; i<=3;i++){
                        System.out.print(result.getString(i)+"  ");
                        }
                    System.out.println("");
                }
                }
            System.out.println("-----------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Información no disponible");
        }
    }
    
    private void borrarUsuario(String tabla){
        String sql;
        String columnas="", respuesta="";
        boolean valido=false;
        columnas = mostrarColumnas(tabla, columnas);
        String columnasG[] = columnas.split(",");
        String cod = columnasG[0];
        
        System.out.println("Introduce "+cod+" del usuario que deseas eliminar: ");
        System.out.print("> ");
        String codigo = sc.nextLine();
        
        do{
           do{
            mostrarAlumno(tabla, cod, codigo);
            System.out.println("¿Deseas realmente borrar este usuario?(s/n)?");
            System.out.print("> ");
            respuesta = sc.nextLine().toLowerCase();
            }while(respuesta.compareTo("s") != 0 && respuesta.compareTo("n") != 0);
           
           if(respuesta.compareTo("n") == 0 ){
               System.out.println("Volviendo al menú...");
               valido = true;
           }else{
               valido = true;
               sql = "DELETE FROM "+tabla+" WHERE "+cod+"='"+codigo+"'";
               consultasUpdate(sql);
           } 
        }while (!valido);

    }
    
    private void borrar(String tabla){
        switch(tabla){
            case "alumno": 
                borrarUsuario(tabla);
                break;
        
            case "alumno_modulo": 
                System.out.println("No se puede realizar la consulta en la tabla "+tabla);
                break;    
            
            case "ciclo": 
                borrarUsuario(tabla);
                break;
                
            case "profesor": 
                borrarUsuario(tabla);
                break;
                
            case "modulo": 
                borrarUsuario(tabla);
                break;
        }
    }
    
}
