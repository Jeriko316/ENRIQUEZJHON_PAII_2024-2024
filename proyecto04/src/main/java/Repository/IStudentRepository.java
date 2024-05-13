package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import IRepository.IRepository;
import modelo.Student;

@Transactional
public class IStudentRepository implements IRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	public void insertar(Student student) {
		// TODO Auto-generated method stub
		 this.entityManager.persist(student);
	}

	@Override
	public Student seleccionar(Integer id) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Student> query = entityManager.createQuery("SELECT e FROM student e WHERE c.id = :datoId", Student.class);
			query.setParameter("datoId", id);

			List<Student> resultados = query.getResultList();

			if (!resultados.isEmpty()) {
				return resultados.get(0);
			} else {
				return null;
			}
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void actualizar(Student student) {
		// TODO Auto-generated method stub
		this.entityManager.merge(student);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Student stuAux = this.seleccionar(id);
		this.entityManager.remove(stuAux);
	}

	

}
