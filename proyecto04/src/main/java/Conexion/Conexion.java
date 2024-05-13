package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection conexion;
	private static Conexion instancia;
	
	private static final String URL= "jdbc:mysql://localhost/instituto";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	
	private Conexion() {
		
	}
	
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Conexion realizada con exito");
			return conexion;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR conexion fallida");
		}
		return conexion;
	}
	
	
	public void cerrarConexion() throws SQLException {
		try {
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error conexxion fallida");
			conexion.close();
		}finally {
			conexion.close();
		}
	}
	
	
	
	public static Conexion getInstance() {
		if(instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}
	
}
