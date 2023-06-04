/**
 * 
 */
package org.learntek.crud.service;

import java.util.List;

import org.learntek.crud.dao.PersonDAO;
import org.learntek.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public boolean createPerson(Person person) {
		// TODO Auto-generated method stub
		return personDAO.createPerson(person);
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return personDAO.getPerson(id);
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDAO.getAllPersons();
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return personDAO.updatePerson(person);
	}

	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return personDAO.deletePerson(id);
	}
}