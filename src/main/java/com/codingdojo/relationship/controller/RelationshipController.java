package com.codingdojo.relationship.controller;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationship.models.License;
import com.codingdojo.relationship.models.Person;
import com.codingdojo.relationship.services.RelationshipService;

@Controller
public class RelationshipController {
	private final RelationshipService relationshipService;
	public RelationshipController(RelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public String createperson(@ModelAttribute("person") Person person) {
            relationshipService.createPerson(person);
            return "redirect:/license";
	}
	@RequestMapping("/license")
	public String license(@ModelAttribute("license") License license, Model model) {
		List<Person> p = relationshipService.allPersons();
		model.addAttribute("person", p);
		return "license.jsp";
	}
	@RequestMapping(value="/license/create", method=RequestMethod.POST)
	public String createlicense(Model model, @RequestParam("exp") String exp,  @ModelAttribute("license") License license) throws ParseException {
		Date f =new SimpleDateFormat("yyyy-MM-dd").parse(exp);
		license.setExpiration_date(f);
		relationshipService.createLicense(license);
		return "redirect:/"; 
	}
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person p = relationshipService.findPerson(id);
		model.addAttribute("p", p);
		model.addAttribute("l", p.getLicense());
		return "show.jsp";
	}
}
