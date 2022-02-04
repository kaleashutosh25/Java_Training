package com.hcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>(
				Arrays.asList(new Employee(1, "Ashutosh", 30, "Dev"), new Employee(2, "Gautam", 28, "Support"),
						new Employee(3, "Vijay", 31, "Networking"), new Employee(4, "Shrikant", 32, "Support"),
						new Employee(5, "Ashutosh", 35, "Dev"), new Employee(6, "Ayush", 26, "Billing"),
						new Employee(7, "Gautam", 30, "Dev"), new Employee(8, "Vijay", 40, "Sales"),
						new Employee(9, "Ashutosh", 50, "HR"), new Employee(10, "Shrikant", 37, "Dev"),
						new Employee(11, "Ashutosh", 30, "Dev"), new Employee(12, "Anupam", 28, "Dev")));

		System.out.println(employees);
		System.out.println();
		System.out.println("--Just making another List--");

		List<Employee> newemployees = employees.stream().collect(Collectors.toList());
		System.out.println(newemployees);
		System.out.println();

		System.out.println("--List of names for employees having  age more than 30-- ");

		List<String> adults = employees.stream().filter((t -> t.getAge() > 30))
				                                .map(t -> t.getName())
				                                .collect(Collectors.toList());

		System.out.println(adults);
		System.out.println();

		System.out.println("New Map--");
		Map<String, String> newMap = employees.stream()
				                              .collect(Collectors.toMap(t1 -> t1.getName(), t2 -> t2.getDepartment(), (t1, t2) -> t2));
		System.out.println(newMap);
	}

}
