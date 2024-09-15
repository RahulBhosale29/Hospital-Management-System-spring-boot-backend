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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSapp.Hospital.Management.System.docappoiment.Medicine;
import com.HMSapp.Hospital.Management.System.docrepository.MedicineRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

	@Autowired
	MedicineRepository medicinerepository; 	
	 
	@PostMapping("/insert")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		
		return medicinerepository.save(medicine);
		
	}
	@GetMapping("/get")
    public List<Medicine>getAllMedicine(){
    	
    	return medicinerepository.findAll();
    }
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
		
		Medicine medicine=medicinerepository.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine not found with id"+id));
		
		return ResponseEntity.ok(medicine);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id,@RequestBody Medicine medicinedetails) throws AttributeNotFoundException{
		
		Medicine medicine=medicinerepository.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine not found with id"+id));
		
		medicine.setDrugName(medicinedetails.getDrugName());
		medicine.setStock(medicinedetails.getStock());
	
		medicinerepository.save(medicine);
		
		return ResponseEntity.ok(medicine);
		
		
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) throws AttributeNotFoundException{
		
	Medicine medicine=medicinerepository.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine not found with id"+id));
	
	medicinerepository.delete(medicine);
	
	Map<String, Boolean> response= new HashMap<String, Boolean>();
	
	response.put("Delete", Boolean.TRUE);
	return ResponseEntity.ok(response);
		
	}
	
	
}

