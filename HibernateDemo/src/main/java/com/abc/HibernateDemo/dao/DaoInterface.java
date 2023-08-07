package com.abc.HibernateDemo.dao;


import java.util.List;

import com.abc.HibernateDemo.model.Employee;

public interface DaoInterface {

	void addEmployee(Employee e);

	void deleteEmp(int i);

	Employee getEmployeeById(int i);

	List<Employee> viewAllEmp();
	public void updateEmployee(Employee updatedEmployee);
}
