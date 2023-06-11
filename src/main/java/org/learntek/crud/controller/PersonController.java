/**
 * 
 */
package org.learntek.crud.controller;

import java.util.List;

import org.learntek.crud.model.Person;
import org.learntek.crud.model.ResponseMessage;
import org.learntek.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 *
 */
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/person")
	public ResponseEntity<ResponseMessage> createEmployee(@RequestBody Person person) {
		ResponseMessage response = new ResponseMessage();
		ResponseEntity<ResponseMessage> entity = null;
		if (personService.createPerson(person)) {
			response.setStatusCode("201");
			response.setStatusMessage("Record Created Successfully...........");
			entity = new ResponseEntity<ResponseMessage>(response, HttpStatus.CREATED);

		}
		return entity;
		/*
		 * else { response.setStatusCode("400");
		 * response.setStatusMessage("Possiblly Duplicate entry...........");
		 * ResponseEntity<ResponseMessage> entity = new
		 * ResponseEntity<ResponseMessage>(response, HttpStatus.BAD_REQUEST); return
		 * entity; }
		 */
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<?> getPerson(@PathVariable("id") int id) {
		System.out.println("backend API called...........");
		Person person = personService.getPerson(id);
		ResponseEntity<Person> responseEntity = null;
		if (person != null) {
			responseEntity = new ResponseEntity<Person>(person, HttpStatus.OK);
//			try {
//				Thread.sleep(80000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
		}
			return responseEntity;
	}

	@GetMapping("/person")
	public ResponseEntity<?> getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		if (!persons.isEmpty()) {
			ResponseEntity<List<Person>> responseEntity = new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
			return responseEntity;
		} else {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setStatusCode("404");
			responseMessage.setStatusMessage("DB is empty.................");
			ResponseEntity<ResponseMessage> responseEntity = new ResponseEntity<ResponseMessage>(responseMessage,
					HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

	@PutMapping("/person")
	public ResponseEntity<ResponseMessage> updatePerson(@RequestBody Person person) {
		ResponseEntity<ResponseMessage> entity = null;
		if (personService.updatePerson(person)) {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setStatusCode("200");
			responseMessage.setStatusMessage("Person Updated Successfully...............");
			entity = new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		}
		return entity;
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
		ResponseEntity<ResponseMessage> responseEntity = null;
		if (personService.deletePerson(id)) {
			responseEntity = new ResponseEntity<ResponseMessage>(HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
}