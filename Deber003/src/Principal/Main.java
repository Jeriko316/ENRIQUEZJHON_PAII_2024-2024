package Principal;

import Conexion.Conexion;
import Modelo.Alumno;
import Modelo.Materia;
import Modelo.Profesor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conexion conectar = Conexion.getInstance();
		conectar.conectar();
		
		Alumno alumno1 = new Alumno();
		alumno1.setId(1);
		alumno1.setName("erick");
		alumno1.setLastName("enriquez");
		alumno1.setAge(25);
		alumno1.insertar(alumno1);
		
		
		Profesor profesor = new Profesor();
		profesor.setId(1);
		profesor.setName("carlos");
		profesor.setLastName("centeno");
		profesor.setAge(35);
		profesor.insertar(profesor);
		
		
		Materia materia = new Materia();
		materia.setId(1);
		materia.setName("erick");
		materia.setDescription("materia de 8vo semestre");
		materia.setLevel(5);
		materia.insertar(materia);
		
		
		
		
	}

}
