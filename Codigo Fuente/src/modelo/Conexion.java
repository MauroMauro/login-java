package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {	   
    
    Connection conn;
    
    public Conexion() {
    }
    
    public Connection getConn() {
    	return this.conn;
    }
    
    public void conectar () {
        

    	 try {
    		 String url = "jdbc:sqlite:src/modelo/basededatos.db";
    		 
    		 // crear conexion a la base de datos
             conn = DriverManager.getConnection(url);
             
             System.out.println("Se establecio conexion a SQLite.");
             
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
    }
    
    public void cerrar(){
        try {
        	 if (conn != null) {
                 conn.close();
                 System.out.println("Se cerro conexion a SQLite");
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 }
	
	
	
	
	
	
	
}

