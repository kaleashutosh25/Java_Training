package com.hcl.dao;

import com.hcl.entity.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import com.hcl.entity.Employee;
public class EmployeeDaoService {

	private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static final String databaseUrl = "jdbc:mysql://localhost:3306/new_database";
	private static final String username = "root";
	private static final String password = "root123";
	private Connection connection = null;

	static {
	initialize();
	}

	public static void initialize() {
	registerDriver();
	}

	private static void registerDriver() {
	try {
	Class.forName(driverClassName);
	} catch(ClassNotFoundException exception) {
	System.out.println(exception);
	}
	}

	private Connection getConnection() {
	try {
	connection = DriverManager.getConnection(databaseUrl, username, password);
	} catch (SQLException exception) {
	System.out.println(exception);
	}
	return connection;
	}

	public void cleanUp() {
	try {
	connection.close();
	} catch (SQLException exception) {
	System.out.println(exception);
	}
	}

	public Employee getEmployee(int id) {
	Connection connection = getConnection();
	Statement statement = null;
	Employee employee = null;
	try {
	statement = connection.createStatement();
	String selectQuery = "select * from employee where id = " + id + "";
	ResultSet resultSet = statement.executeQuery(selectQuery);
	if (resultSet.next()) {
	int id_ = resultSet.getInt("id");
	String name = resultSet.getString("name");
	int salary = resultSet.getInt("salary");
	int departmentId = resultSet.getInt("department_id");
	employee = new Employee(id_, name,salary, departmentId);
	} else {
	System.out.println("Employee#" + id + " not found.");
	}
	} catch (SQLException exception) {
	System.out.println(exception);
	} finally {
	cleanUp();
	}
	return employee;
	}

	public List<Employee> getEmployees() {
	List<Employee> employees = new ArrayList<>();
	Connection connection = getConnection();
	Statement statement = null;
	try {
	statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("select * from employee");
	while (resultSet.next()) {
	int id = resultSet.getInt("id");
	String name = resultSet.getString("name");
//	String mobile = resultSet.getString("mobile");
//	String email = resultSet.getString("email");
	int salary = resultSet.getInt("salary");
	int department_Id = resultSet.getInt("department_id");
	Employee employee = new Employee(id, name, salary, department_Id);
	employees.add(employee);
	}
	} catch (SQLException exception) {
	System.out.println(exception);
	} finally {
	cleanUp();
	}
	return employees;
	}
	
	public void addEmployee ( Employee employee) {
		
		Connection connection = getConnection();
		Statement statement = null;
		int id=employee.getId();
		System.out.println(id);
		String name=employee.getName();
		int salary = employee.getSalary();
		int department_id=employee.getDepartmentId();
		System.out.println(department_id);
		
		//Employee employee = null;
		
		try {
			statement = connection.createStatement();
			String addQuery = "insert into employee values (id,name,salary,department_id)";
			//statement.execute("insert into employee values (9999,"Vijay",70000,44)";);
			statement.execute(addQuery);
			System.out.println("Record Added");
		} catch (SQLException exception) {
			System.out.println(exception);
			} finally {
			cleanUp();
			}
	}
	}

