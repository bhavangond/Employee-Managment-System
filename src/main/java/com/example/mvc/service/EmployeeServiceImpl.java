package com.example.mvc.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mvc.entity.Employee;
import com.example.mvc.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository emp;
	@Override
	public List<Employee> findAll() {
		
		return emp.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return emp.findById(id);
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return emp.save(employee);
	}

	@Override
	public void deleteById(int id) {
		emp.deleteById(id);
		
	}

}
