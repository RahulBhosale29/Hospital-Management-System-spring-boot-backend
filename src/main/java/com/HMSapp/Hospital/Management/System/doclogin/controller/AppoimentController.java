package com.HMSapp.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSapp.Hospital.Management.System.docappoiment.Appoiment;
import com.HMSapp.Hospital.Management.System.docrepository.AppoimentRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class AppoimentController {

	@Autowired
	AppoimentRepository appoimentrepository;
	
	@PostMapping("/insert")
	public Appoiment createAppoiment(@RequestBody Appoiment appoiment) {
	
	return appoimentrepository.save(appoiment);
	}
	
	@GetMapping("/get")
	public List<Appoiment>getAllAppoiments(){
		
		return appoimentrepository.findAll();
		
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public  ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
		
	Appoiment appointment=appoimentrepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not found with id"+id));
		
		appoimentrepository.delete(appointment);
		
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		response.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
}
