/**
 * 
 */
package org.learntek.crud.exception;

/**
 * @author HP
 *
 */
public class PersonNotAvailableException extends RuntimeException {
	private String message;
	
	public PersonNotAvailableException(String message, int id) {
		this.message = message+" : "+id;
	}
	
	public String getMessage() {
		return message;
	}
}
