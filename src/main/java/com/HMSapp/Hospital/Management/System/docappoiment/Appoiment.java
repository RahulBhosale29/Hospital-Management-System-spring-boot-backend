package com.HMSapp.Hospital.Management.System.docappoiment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Appoiment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String age;
	private String symtomps;
	private String number;
	public Appoiment(int id, String name, String age, String symtomps) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.symtomps = symtomps;
	}
	
	
	
}
