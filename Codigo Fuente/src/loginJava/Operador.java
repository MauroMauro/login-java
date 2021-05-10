package loginJava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Conexion;

public class Operador {
	private String nombre;
	private String clave;
	
	public Operador(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}
	
	
	//getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	/**
	 * El metodo retorna true si los datos del operador se encuentran en la base de datos
	 * @return
	 */
	public boolean buscarUsuarioEnLaBDs() {
		
		boolean res = false;
		Conexion conn = new Conexion();
		
		conn.conectar();
		
		try {
			Statement st = conn.getConn().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuariosRegistrados");
			
			while(rs.next()) {	
				if(rs.getString("nombre").equals(this.nombre) && rs.getString("clave").equals(this.clave)) {
					res = true;
				}
			}
			
			if(!res) {
		    	JOptionPane.showMessageDialog(null, "El usuario "+this.nombre+" no se encuentra en la BDs");
			}
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
		
		
		conn.cerrar();
		
		return res;
	}
	
	/**
	 * El metodo retorna true si los datos del operador se guardan en la base de datos
	 * @return
	 */
	public boolean registrarUsuarioEnLaBDs() {
		
		boolean res = false;
		Conexion conn = new Conexion();
		
		conn.conectar();
		
		try {
			Statement st = conn.getConn().createStatement();
			st.executeUpdate("INSERT INTO usuariosRegistrados VALUES ('"+this.nombre+"','"+this.clave+"')");
			
			res = true;

	    	JOptionPane.showMessageDialog(null, "El usuario "+this.nombre+" se há registrado en la BDs");
			
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
		
		
		conn.cerrar();
		
		return res;
	}
	
	/**
	 * El metodo retorna true si los datos del operador se borraron de la base de datos
	 * @return
	 */
	public boolean borrarUsuarioDeLaBDs() {
		
		boolean res = false;
		Conexion conn = new Conexion();
		
		conn.conectar();
		
		try {
			Statement st = conn.getConn().createStatement();
			st.executeUpdate("DELETE FROM usuariosRegistrados WHERE nombre = '"+this.nombre+"'");
			
			res = true;
			
	    	JOptionPane.showMessageDialog(null, "ATENCIÓN: El usuario: "+this.nombre+" se há borrado de la BDs");

			
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
		
		
		conn.cerrar();
		
		return res;
	}
	
}
