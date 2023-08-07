package com.abc.HibernateDemo.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.HibernateDemo.model.Employee;

public class DaoImpl implements DaoInterface{

	SessionFactory sf=null;
	public DaoImpl() {
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	

	public void addEmployee(Employee e) {
        Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		session.save(e); 
		txn.commit(); 
		
		session.close(); 
		
		
	}



	@Override
	public void deleteEmp(int id) {
		Session session=sf.openSession();
		Transaction txn=session.beginTransaction();
		Employee e=session.get(Employee.class, id);  // get record from db
		session.delete(e);
		txn.commit();
		
		session.close(); 
		
	}



	@Override
	public Employee getEmployeeById(int i) {
		Session session=sf.openSession();
		
		Employee e=session.get(Employee.class, i); 
		session.close();
		return e; 
	} 



	@Override
	public List<Employee> viewAllEmp() {
		
		Session session=sf.openSession();
		
		
		Query query = (Query) session.createQuery("from Employee");
		
		List<Employee> el=query.list(); 
		session.close();
		return el; 
	}



	@Override
	public void updateEmployee(Employee updatedEmployee) {
		Session session = sf.openSession();
	    
	    Transaction txn = session.beginTransaction();

	    
	    Employee existingEmployee = session.get(Employee.class, updatedEmployee.getId());

	    if (existingEmployee != null) {
	        
	        existingEmployee.setCity(updatedEmployee.getCity());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        existingEmployee.setEname(updatedEmployee.getEname());
	        existingEmployee.setSalary(updatedEmployee.getSalary());

	        
	        session.update(existingEmployee);
	    }

	    txn.commit();
	    session.close();
	}
	





		
	}
	

