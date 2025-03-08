package com.example.mvc.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entity.*;

import com.example.mvc.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model ) {
		List<Employee> emps=employeeService.findAll();
		model.addAttribute("employees",emps);
		return "list-emps";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee employee=new Employee();
		theModel.addAttribute("employee",employee);
		return "employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		Optional<Employee> theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee",theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/list";
	}

}
