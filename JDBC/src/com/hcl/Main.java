package com.hcl;

import java.util.List;



import com.hcl.entity.Employee;
import com.hcl.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main main = new Main();
		main.go();
		}

		private void go() {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = employeeService.getEmployee(1111);
		System.out.println(employee);
	System.out.println("-------------------------");
	List<Employee> employees = employeeService.getEmployees();
	System.out.println(employees);
		System.out.println("-------------------------");

	Employee newEmployee = new Employee(9999, "Vijay", 80000,11);
		employeeService.addEmployee(newEmployee);
		}
		
		

	}


