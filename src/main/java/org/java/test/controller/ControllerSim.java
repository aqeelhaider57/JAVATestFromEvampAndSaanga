package org.java.test.controller;

import java.util.List;

import org.java.test.dto.DtoSim;
import org.java.test.service.ServiceSim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sim")
public class ControllerSim {
	
	@Autowired
	private ServiceSim serviceSim;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody DtoSim dtoSim){
		
		ResponseEntity<String> returnTypEntity = null;
		
		if(dtoSim != null) {
			boolean result = serviceSim.create(dtoSim);
			if(result) {
				returnTypEntity = new ResponseEntity<>("Successfully created", HttpStatus.CREATED);	
			}else {
				returnTypEntity = new ResponseEntity<>("Not created", HttpStatus.NOT_ACCEPTABLE);
			}
			
		}
		return returnTypEntity;
	}
	
	@PostMapping("/simForCustomer")
	public ResponseEntity<String> linkSimToCustomer(@RequestBody DtoSim dtoSim){
		
		ResponseEntity<String> returnTypEntity = null;
		
		if(dtoSim != null) {
			boolean result = serviceSim.updateSimForCustomer(dtoSim);
			if(result) {
				returnTypEntity = new ResponseEntity<>("Update Successfully", HttpStatus.OK);	
			}else {
				returnTypEntity = new ResponseEntity<>("Not update", HttpStatus.BAD_REQUEST);
			}
			
		}
		return returnTypEntity;
	}
	
	@PostMapping("/getByCustomerId")
	public ResponseEntity<List<DtoSim>> getByCustomerId(@RequestBody DtoSim dtoSim){
		ResponseEntity<List<DtoSim>> returnTypEntity = null;
		List<DtoSim> dtoSims = serviceSim.findByCustomerId(dtoSim);
		if (dtoSims != null) {
			returnTypEntity =  new ResponseEntity<>(dtoSims, HttpStatus.FOUND);
		}else {
			returnTypEntity =  new ResponseEntity<>(dtoSims, HttpStatus.NOT_FOUND);
		}
		
	return	returnTypEntity;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DtoSim>> getAll(){
		ResponseEntity<List<DtoSim>> returnTypEntity = null;
		List<DtoSim> dtoSims = serviceSim.getAll();
		if (dtoSims != null) {
			returnTypEntity =  new ResponseEntity<>(dtoSims, HttpStatus.FOUND);
		}else {
			returnTypEntity =  new ResponseEntity<>(dtoSims, HttpStatus.NOT_FOUND);
		}
		
	return	returnTypEntity;
	}
	
	

}
