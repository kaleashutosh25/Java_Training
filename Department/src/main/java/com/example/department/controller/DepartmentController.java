package com.example.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.model.Department;
import com.example.department.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("departments")
	public List<Department> getAllDepartments()
	{
		return departmentService.getAllDepartments() ;
	}
	
	@GetMapping("departments/{id}")
	public Department getSingleDepartment(@PathVariable int id )
	{
		return departmentService.getSingleDepartment(id) ;
	}
	
	@PostMapping("departments")
	public  Department createDepartments(@RequestBody Department department )
	{
		return  departmentService.createDepartments(department) ;
	}
	
	@PutMapping("departments")
	public Department updateDepartments(@RequestBody Department department )
	{
		return departmentService.updateDepartments(department) ;
	}
	
	@DeleteMapping("departments/{id}")
	public void deleteDepartments(@PathVariable int id  )
	{
		 departmentService.deleteDepartments(id) ;
	}
	

}
