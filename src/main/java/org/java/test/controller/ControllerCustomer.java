package org.java.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.test.dto.DtoCustomer;
import org.java.test.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class ControllerCustomer {

	@Autowired
	private ServiceCustomer serviceCustomer;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody DtoCustomer dtoCustomer){
		
		ResponseEntity<String> returnTypEntity = null;
		if (dtoCustomer != null) {
		boolean result = serviceCustomer.create(dtoCustomer);
		if(result) {
			returnTypEntity = new ResponseEntity<>("Successfully created", HttpStatus.CREATED);	
		}else {
			returnTypEntity = new ResponseEntity<>("Not created", HttpStatus.NOT_ACCEPTABLE);
		}
		}
		
		return returnTypEntity;
	}
}
