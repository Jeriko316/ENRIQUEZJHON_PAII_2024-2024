package IService;

import modelo.Student;

public interface IServiceStudent {

	public void agregar(Student student);
	public void seleccionar(Integer id);
	public void actualizar(Student student);
	public void eliminar(Integer id);
}
