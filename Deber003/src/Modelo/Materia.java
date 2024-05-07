package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexion.Conexion;
import Interfaces.IMateria;

public class Materia implements IMateria{
	private Integer id;
	private String name;
	private String description;
	private Integer level;
	
	Conexion conectar = Conexion.getInstance();
	Connection conexion = conectar.conectar();
	
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
try {
			
			PreparedStatement insertar = conexion.prepareStatement("INSERT INTO materia VALUES(?,?,?,?)");
			insertar.setInt(1, materia.getId());
			insertar.setString(1, materia.getName());
			insertar.setString(1, materia.getDescription());
			insertar.setInt(1, materia.getLevel());
			insertar.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("nO SE INGRESARON LOS DATOS");
		}
	}
	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void seleccionar(Materia materia) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Materia materia) {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
	
	
	
}
