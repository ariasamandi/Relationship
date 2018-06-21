package com.codingdojo.relationship.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.repositories.LicenseRepository;
import com.codingdojo.relationship.repositories.PersonRepository;

@Service
public class RelationshipService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	public RelationshipService(PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	public Person createPerson(Person b) {
		return personRepository.save(b);
	}
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	public License createLicense(License a) {
		return licenseRepository.save(a);
	}
	public Person findPerson(Long id) {
		Optional<Person> p = personRepository.findById(id);
		if(p.isPresent()) {
			return p.get();
	     } else {
	         return null;
	     }
	}
}
