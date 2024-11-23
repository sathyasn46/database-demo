package learn.backend.database.databasedemo.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import learn.backend.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	//connect to database
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id) ; // JPA
	}
	
	public Person insert(Person person) {
		 return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		 return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll() {
		//Person person = findById(id);
		 TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		 return namedQuery.getResultList();
	}
}
