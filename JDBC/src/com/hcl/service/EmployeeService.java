package com.hcl.service;

import java.util.Collections;
import java.util.List;

import com.hcl.dao.EmployeeDaoService;
import com.hcl.entity.Employee;

public class EmployeeService {
	
	public Employee getEmployee(int id) {
		EmployeeDaoService employeeDaoService = new EmployeeDaoService();
		Employee employee = employeeDaoService.getEmployee(id);
		return employee;
		}

		public List<Employee> getEmployees() {
		EmployeeDaoService employeeDaoService = new EmployeeDaoService();
		List<Employee> employees = employeeDaoService.getEmployees();
		return employees;

		}

		public void addEmployee(Employee employee) {
		
			EmployeeDaoService employeeDaoService = new EmployeeDaoService();
			employeeDaoService.addEmployee(employee);
		}
		public void addEmployee(List<Employee> employees) {
		}

		public void deleteEmployee(int id) {
		}

		public void deleteEmployees() {
		}

		public void updateEmployee(Employee employee) {
		}

		public void updateEmployees(List<Employee> employees) {
		}
		}


