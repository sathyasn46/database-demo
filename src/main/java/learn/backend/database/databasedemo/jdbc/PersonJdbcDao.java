package learn.backend.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import learn.backend.database.databasedemo.entity.Person;


@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
	}

	//Select * FROM Person;
	public List<Person> findAllCustom(){
		return jdbcTemplate.query("Select * FROM Person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByIdCustom(int id) {
		return jdbcTemplate.queryForObject("Select * FROM Person WHERE id = ?", new Object[] {id}, 
				new PersonRowMapper());
	}
	
	public List<Person> searchByName(String name) {
		return jdbcTemplate.query("Select * FROM Person WHERE name = ?", new Object[] {name}, 
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("insert into person( id , name , location , birth_date ) values ( ?, ? , ?, ?)",
				new Object[] {
						person.getId(), person.getName(),person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ? ",
				new Object[] {id});
	}
	
	public int updateLocation(Person person) {
		return jdbcTemplate.update("Update person set location = ? where name = ?",
				new Object[] {person.getLocation(),  person.getName()});
	}

	public int updatePersonById(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date =? "
				+ "where id = ?", new Object[] {person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
	}
}
