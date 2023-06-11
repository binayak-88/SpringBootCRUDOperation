/**
 * 
 */
package org.learntek.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author HP
 *
 */
@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(PersonNotAvailableException.class)
	public ResponseEntity<MyError> handlePersonNotFoundException(PersonNotAvailableException e){
		MyError error = new MyError();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(error,HttpStatus.BAD_REQUEST);
		return responseEntity;
		
	}
	
	
	@ExceptionHandler(PersonAlreadyExistException.class)
	public ResponseEntity<MyError> handlePersonAlreadyExistException(PersonAlreadyExistException e){
		MyError error = new MyError();
		error.setErrorCode("400");
		error.setErrorMessage(e.getMessage());
		
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(error,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@ExceptionHandler(CannotGetJdbcConnectionException.class)
	public ResponseEntity<MyError> handleDBConnectionException(CannotGetJdbcConnectionException e){
		MyError error = new MyError();
		error.setErrorCode("500");
		error.setErrorMessage(e.getMessage());
		
		ResponseEntity<MyError> responseEntity = new ResponseEntity<MyError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
}
