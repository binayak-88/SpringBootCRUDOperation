/**
 * 
 */
package org.learntek.crud.service;

import java.util.List;

import org.learntek.crud.model.Person;

/**
 * @author HP
 *
 */
public interface PersonService {
	public boolean createPerson(Person person);
	public Person getPerson(int id);
	public List<Person> getAllPersons();
	public boolean updatePerson(Person person);
	public boolean deletePerson(int id);
}
