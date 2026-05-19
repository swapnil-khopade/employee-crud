package com.example.employeecrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {
	
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		model.addAttribute("employees",service.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";	
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee( @PathVariable Long id ,Model model) {
		model.addAttribute("employee",service.getEmployeeById(id));
		return "add_employee";
	}
	
	@GetMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id ) {
		service.deleteEmployee(id);
		return "redirect:/";
	}
	
	
	
	
	
	
}
