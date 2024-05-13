package IService;

import Repository.IStudentRepository;
import modelo.Student;


public class ServiceStudentImpl implements IServiceStudent {

	
	private IStudentRepository stuRepo;
	
	@Override
	public void agregar(Student student) {
		// TODO Auto-generated method stub
		this.stuRepo.insertar(student);
	}

	@Override
	public void seleccionar(Integer id) {
		// TODO Auto-generated method stub
		this.stuRepo.seleccionar(id);
	}

	@Override
	public void actualizar(Student student) {
		// TODO Auto-generated method stub
		this.stuRepo.actualizar(student);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.stuRepo.eliminar(id);
	}

}
