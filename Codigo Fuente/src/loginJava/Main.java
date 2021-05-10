package loginJava;


import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {    	
    	inicio();    
    }
    
    
    
    public static void inicio() {
    	
    	String[] opciones = {"Ingresar", "Registrar nuevo usuario", "Borrar un usuario"};
    	
    	int seleccion = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú de ingreso", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones);
    	
    	switch(seleccion) {
    	 	case 0: if(login()) {
    	 					JOptionPane.showMessageDialog(null, "Acceso concedido");
    	 					menuPrincipal();    	 					
    	 			}
    	 			break;
    	 			
    	 	case 1: if(registrar()) {inicio();}
    	 			break;
    	 			
    	 	case 2: if(borrar()) {inicio();}
 					break;
    	}    	
    }
    
    
    /**
     * El método pide el ingreso de datos, si los datos son válidos, retorna true. Sino, acciona el metodo "inicio() y retorna false"
     * @return
     */
    public static boolean login () {    	
    	
    	String usuario = JOptionPane.showInputDialog("Ingrese Usuario:");
    	String clave = JOptionPane.showInputDialog("Ingrese clave");
    	
    	Operador operador = new Operador(usuario, clave); 
    	
    	if(operador.buscarUsuarioEnLaBDs()) {
    		return true;
    	}else {
    		inicio();
    		return false;
    	}
    	
    }
    
    
    /**
     * El método pide el ingreso de datos para registrar un nuevo Usuario. 
     * @return Retornará true si el Usuario se pudo registrar.
     */
    public static boolean registrar() {
    	System.out.println("Metodo registrar activado");
    	
    	String usuario = JOptionPane.showInputDialog("Ingrese Usuario:");
    	String clave = JOptionPane.showInputDialog("Ingrese clave");
    	
    	Operador operador = new Operador(usuario, clave); 
    	
    	return operador.registrarUsuarioEnLaBDs();
    }
    
    /**
     * El método pide el ingreso de datos para borrar un Usuario de la Base de datos
     * @return Retornará true si el Usuario se pudo borrar
     */
    public static boolean borrar() {
    	System.out.println("Metodo borrar activado");
    	
    	String usuario = JOptionPane.showInputDialog("Ingrese Usuario:");
    	String clave = JOptionPane.showInputDialog("Ingrese clave");
    	
    	Operador operador = new Operador(usuario, clave); 
    	
    	if(operador.buscarUsuarioEnLaBDs()) {
    		return operador.borrarUsuarioDeLaBDs();
    	}else {
    		JOptionPane.showMessageDialog(null, "ATENCIÓN: El usuario "+operador.getNombre()+" no se encuentra en la BDs");
    		inicio();
    		return false;
    	}
    	
    }
    
    
    public static void menuPrincipal() {
    	System.out.println("Menu Principal\n=================\n");
    }
    
 
    
}
