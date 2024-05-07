package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexion.Conexion;
import Interfaces.IAlumno;

public class Alumno implements IAlumno{

	private Integer id;
	private String name;
	private String lastName;
	private Integer age;
	
	Conexion conectar = Conexion.getInstance();
	Connection conexion = conectar.conectar();
	
	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		try {
			
			PreparedStatement insertar = conexion.prepareStatement("INSERT INTO alumno VALUES(?,?,?,?)");
			insertar.setInt(1, alumno.getId());
			insertar.setString(1, alumno.getName());
			insertar.setString(1, alumno.getLastName());
			insertar.setInt(1, alumno.getId());
			insertar.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("nO SE INGRESARON LOS DATOS");
		}
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seleccionar(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Conexion getConectar() {
		return conectar;
	}

	public void setConectar(Conexion conectar) {
		this.conectar = conectar;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	
	
	
}
