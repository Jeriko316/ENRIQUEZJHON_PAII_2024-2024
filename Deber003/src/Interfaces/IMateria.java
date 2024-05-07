package Interfaces;

import Modelo.Alumno;
import Modelo.Materia;

public interface IMateria {

	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public void seleccionar(Materia materia);
	public void eliminar(Materia materia);
}
