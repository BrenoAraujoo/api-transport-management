package com.transport.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.entities.Transport;
import com.transport.service.TransportService;

@RestController
@RequestMapping("/Transports")
public class TransportController {

	@Autowired
	private TransportService transportService;

	@GetMapping
	public ResponseEntity<List<Transport>> list() {
		List<Transport> list = transportService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Transport> findById(@PathVariable Long id) {
		Transport transp = transportService.findById(id);
		return ResponseEntity.ok().body(transp);
	}

	@PostMapping
	public ResponseEntity<Transport> save(@Valid @RequestBody Transport transport) {
		transport = transportService.save(transport);
		return ResponseEntity.ok().body(transport);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@Valid @PathVariable Long id) {
		transportService.delete(id);
		return new ResponseEntity<>("Sucessfully deleted: " + 
		id, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Transport transport){
		transportService.update(transport);
		return new ResponseEntity<>("Sucessfully updated: " + 
		transport.getCompany().getName(),HttpStatus.OK);
	}
}
