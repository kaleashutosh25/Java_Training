package com.example.department.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	
	
//	 List<Department> department = Arrays.asList(
//			 new Department (1,"Develpoment","DEPT"),
//			 new Department (2,"Testing","TEST"),
//			 new Department (3,"Support","SPRT"),
//			 new Department (4,"Business","BUSS")
//			 
//			 );
	@Autowired
	private DepartmentRepository departmentRepository;

	 
	 public List<Department> getAllDepartments()
	 {
		 return departmentRepository.findAll();
	 }
	 
	 public Department getSingleDepartment(int id)
	 {
		 return departmentRepository.getById(id);
				 
	 }

	public Department createDepartments(Department department) {
		return departmentRepository.save(department);
			
	}



	public Department updateDepartments(Department department) {
		return departmentRepository.save(department);
		
	}

	public void deleteDepartments(int id) {
		departmentRepository.deleteById(id);
		
	}
}
