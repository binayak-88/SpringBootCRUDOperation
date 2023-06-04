/**
 * 
 */
package org.learntek.crud.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author HP
 *
 */
public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setState(rs.getString("state"));
		person.setCity(rs.getString("city"));
		person.setName(rs.getString("name"));
		person.setCountry(rs.getString("country"));
		
		return person;
	}

}
