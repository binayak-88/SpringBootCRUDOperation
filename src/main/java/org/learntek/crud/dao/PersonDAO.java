/**
 * 
 */
package org.learntek.crud.dao;

import java.util.List;

import org.learntek.crud.model.Person;

/**
 * @author HP
 *
 */
public interface PersonDAO {
	public boolean createPerson(Person person);
	public Person getPerson(int id);
	public List<Person> getAllPersons();
	public boolean updatePerson(Person person);
	public boolean deletePerson(int id);
}
