package learn.backend.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import learn.backend.database.databasedemo.entity.Person;
import learn.backend.database.databasedemo.jdbc.PersonJdbcDao;
import learn.backend.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class DatabaseDemoApplicationJpa implements CommandLineRunner{

	@Autowired
	PersonJpaRepository personJpaRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplicationJpa.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("\n===JPA Spring boot app===");

		logger.info("\nFind Person by ID 10002 -> {}",personJpaRepo.findById(10002));
		//logger.info("\nInsert Person ->{}",personJpaRepo.insert(new Person("James Gosling","US",new Date())));
		logger.info("\nInsert Person ->{}",personJpaRepo.insert(new Person("Tywin","King's Landing",new Date())));
		logger.info("\nUpdate Person ->{}",personJpaRepo.update(new Person("Daenerys Stormborn","King's Landing",new Date())));
		logger.info("\nInsert Person ->{}",personJpaRepo.insert(new Person("Tywin Lannister","King's Landing",new Date())));
		logger.info("\nAll Persons -> {}",personJpaRepo.findAll());

		//personJpaRepo.deleteById(10003);
//		logger.info("\n Find Person by Name -> {}",personJpaRepo.searchByName("Sathya"));
//		logger.info("\n Insert Person -> {}",personJpaRepo.insertPerson(new Person(10021,"Rocky","Mumbai", new Date())));
//		logger.info("\n Insert Person -> {}",personJpaRepo.insertPerson(new Person(10022,"Jon Snow","Nights watch", new Date())));
//		logger.info("\n Insert Person -> {}",personJpaRepo.insertPerson(new Person(10030,"Ned","Winterfell", new Date())));
//		logger.info("\n Insert Person -> {}",personJpaRepo.insertPerson(new Person(10023,"Daenerys","East", new Date())));
//		logger.info("\n Insert Person -> {}",personJpaRepo.insertPerson(new Person(10024,"Tyrion","Kings Landing", new Date())));
//		logger.info("\nAll persons -> {}",personJpaRepo.findAllCustom());
//		logger.info("\n Delete Person By Id -> {}",personJpaRepo.deleteById(10030));
//		logger.info("\n Update Person location -> {}",personJpaRepo.updateLocation(new Person(10023,"Daenerys","West", new Date())));
//		logger.info("\n Update Person by ID -> {}",personJpaRepo.updatePersonById(new Person(10024,"Tyrion Lannister","East", new Date())));
//		logger.info("\nAll persons -> {}",personJpaRepo.findAllCustom());
	}

}
