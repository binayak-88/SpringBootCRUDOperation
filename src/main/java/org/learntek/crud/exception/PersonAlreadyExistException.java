/**
 * 
 */
package org.learntek.crud.exception;

/**
 * @author HP
 *
 */
public class PersonAlreadyExistException extends RuntimeException {
	private String message;
	
	public PersonAlreadyExistException(String message, int id) {
		this.message = message+" : "+id;
	}
	
	public String getMessage() {
		return message;
	}
}
