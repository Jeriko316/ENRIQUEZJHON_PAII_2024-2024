package IRepository;

import modelo.Student;

public interface IRepository {
	public void insertar(Student student);
	public Student seleccionar(Integer id);
	public void actualizar(Student student);
	public void eliminar(Integer id);
}
