package cz.fio.testjavista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fio.testjavista.csv.SaveEmployee;
import cz.fio.testjavista.entity.Employee;

@RestController
@RequestMapping("/test-javista")
public class TestJavistaApplicationController {

	@GetMapping("/contact")
	public void employee(
			 @RequestParam(value="firstName", required=true) String firstName,
			 @RequestParam(value="lastName", required=true) String lastName,
			 @RequestParam(value="email", required=true) String email) {
		Employee employee = new Employee(firstName, lastName, email);
		SaveEmployee.save(employee);
		
	}
}
