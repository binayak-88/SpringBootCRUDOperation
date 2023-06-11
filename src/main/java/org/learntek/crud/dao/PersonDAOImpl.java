/**
 * 
 */
package org.learntek.crud.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.learntek.crud.exception.PersonAlreadyExistException;
import org.learntek.crud.model.Person;
import org.learntek.crud.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public boolean createPerson(Person person) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = template.update("insert into person values(?,?,?,?,?)", person.getId(), person.getCity(),
					person.getCountry(), person.getName(), person.getState());
		}
		catch (DataAccessException e) {
			// TODO: handle exception
			if(e.contains(SQLIntegrityConstraintViolationException.class)) {
				PersonAlreadyExistException pe = new PersonAlreadyExistException("Person already exist in DB with id ", person.getId());
				throw pe;
			}
			if(e.contains(CannotGetJdbcConnectionException.class)) {
				throw e;
			}
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		PersonMapper personMapper = new PersonMapper();
		List<Person> persons = template.query("select * from person where id=?", new Object[] { id }, personMapper);
		if (persons.size() > 0)
			return persons.get(0);
		else
			return null;
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		PersonMapper personMapper = new PersonMapper();
		List<Person> persons = template.query("select * from person", personMapper);
		return persons;
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		int res = template.update("update person set city=? where id=?", person.getCity(), person.getId());
		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		int res = template.update("delete from person where id=?", id);
		if (res == 1)
			return true;
		else
			return false;
	}
}
