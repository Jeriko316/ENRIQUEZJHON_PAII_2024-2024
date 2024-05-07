package Interfaces;

import Modelo.Alumno;

public interface IAlumno {

	public void insertar(Alumno alumno);
	public void actualizar(Alumno alumno);
	public void seleccionar(Alumno alumno);
	public void eliminar(Alumno alumno);
}
