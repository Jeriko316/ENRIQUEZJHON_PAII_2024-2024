package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexion.Conexion;
import Interfaces.IProfesor;

public class Profesor implements IProfesor {
	private Integer id;
	private String name;
	private String lastName;
	private Integer age;
	
	Conexion conectar = Conexion.getInstance();
	Connection conexion = conectar.conectar();
	
	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
try {
			
			PreparedStatement insertar = conexion.prepareStatement("INSERT INTO profesor VALUES(?,?,?,?)");
			insertar.setInt(1, profesor.getId());
			insertar.setString(1, profesor.getName());
			insertar.setString(1, profesor.getLastName());
			insertar.setInt(1, profesor.getId());
			insertar.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("nO SE INGRESARON LOS DATOS");
		}
	}
	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void seleccionar(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Profesor profesor) {
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
	
	
	
	
}
