package com.HMSapp.Hospital.Management.System.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSapp.Hospital.Management.System.entity.Patient;
import com.HMSapp.Hospital.Management.System.repository.PatientRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PatientController {

	@Autowired
	private PatientRepository parientrepostitory;

	@PostMapping("/insert")
	private Patient createpatient(@RequestBody Patient patient) {
		
		return parientrepostitory.save(patient);
	}
	
	
	@GetMapping("/get")
	public List<Patient>getAllPatient(){
		return parientrepostitory.findAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		
		Patient patient=parientrepostitory.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient Not Found With Id:"+id));

		return ResponseEntity.ok(patient);
	
	}
	

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>>deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		
	Patient patient	=parientrepostitory.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
	
	parientrepostitory.delete(patient);
	
	Map<String, Boolean> response=new HashMap<String, Boolean>();
	
	response.put("Delete", Boolean.TRUE);
	
	return ResponseEntity.ok(response);
	}
	
    @PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable long id ,@RequestBody Patient patientdetails) throws AttributeNotFoundException{
	
    Patient patient	=parientrepostitory.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
    	
    patient.setAge(patientdetails.getAge());
    patient.setBlood_group(patientdetails.getBlood_group());
    patient.setDose(patientdetails.getDose());
    patient.setName(patientdetails.getName());
    patient.setPrescription(patientdetails.getPrescription());
    patient.setUrgency(patientdetails.getUrgency());
    
    Patient savedPatient =parientrepostitory.save(patient);
    	
    return ResponseEntity.ok(savedPatient);
    
	}
	
}


