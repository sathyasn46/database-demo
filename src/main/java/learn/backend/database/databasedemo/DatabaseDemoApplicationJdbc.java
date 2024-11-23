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

@SpringBootApplication
public class DatabaseDemoApplicationJdbc implements CommandLineRunner{

	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplicationJdbc.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("\nPerson by ID 10003 -> {}",dao.findByIdCustom(10003));
		logger.info("\n Find Person by Name -> {}",dao.searchByName("Sathya"));
		logger.info("\n Insert Person -> {}",dao.insertPerson(new Person(10021,"Rocky","Mumbai", new Date())));
		logger.info("\n Insert Person -> {}",dao.insertPerson(new Person(10022,"Jon Snow","Nights watch", new Date())));
		logger.info("\n Insert Person -> {}",dao.insertPerson(new Person(10030,"Ned","Winterfell", new Date())));
		logger.info("\n Insert Person -> {}",dao.insertPerson(new Person(10023,"Daenerys","East", new Date())));
		logger.info("\n Insert Person -> {}",dao.insertPerson(new Person(10024,"Tyrion","Kings Landing", new Date())));
		logger.info("\nAll persons -> {}",dao.findAllCustom());
		logger.info("\n Delete Person By Id -> {}",dao.deleteById(10030));
		logger.info("\n Update Person location -> {}",dao.updateLocation(new Person(10023,"Daenerys","West", new Date())));
		logger.info("\n Update Person by ID -> {}",dao.updatePersonById(new Person(10024,"Tyrion Lannister","East", new Date())));
		logger.info("\nAll persons -> {}",dao.findAllCustom());
	}

}
