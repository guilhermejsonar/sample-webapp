package com.lab.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.employee.entity.Department;
import com.lab.employee.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentRepository repository;

	@GetMapping()
	public ResponseEntity<List<Department>> getAll() {
		List<Department> data = repository.findAll();
		return ResponseEntity.ok().body(data);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> get(@PathVariable("id") Integer id) {
		Optional<Department> employee = repository.findById(id);
		if (employee.isPresent())
			return ResponseEntity.ok().body(employee.get());
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping()
	public Department save(@RequestBody Department employee) {
		return repository.save(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		Boolean response = true;
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			response = false;
		}
		return ResponseEntity.accepted().body(response);
	}
}