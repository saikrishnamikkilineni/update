package com.abc.HibernateDemo;

import java.util.List;
import java.util.Scanner;

import com.abc.HibernateDemo.dao.DaoImpl;
import com.abc.HibernateDemo.dao.DaoInterface;
import com.abc.HibernateDemo.model.Employee;

public class App 
{
	Scanner sc=new Scanner(System.in);
	DaoInterface dao=new DaoImpl();
	
	 //Add employee details   
	public void add() {
       Employee e=new Employee();
       System.out.println("Enter the employee id :");
		e.setId(sc.nextInt());
		System.out.println("Enter the employee name :");
	    e.setEname(sc.next());
		System.out.println("Enter Employee city :");
		e.setCity(sc.next());
		System.out.println("Enter employee email :");
		e.setEmail(sc.next());
		System.out.println("Enter the employee salary :");
		e.setSalary(sc.nextDouble());
        
		dao.addEmployee(e);  
		
		}

	  //delete employee details 
	public void delete() {
       dao.deleteEmp(103); 
	}
         
         //get employee details by id
	public void id() {
		
       Employee e1=dao.getEmployeeById(101);
        System.out.println("EID: "+e1.getId());
        System.out.println("EName: "+e1.getEname()); 
        System.out.println("Ecity :"+e1.getCity());
        System.out.println("Email :"+e1.getEmail());
        System.out.println("Salary :"+e1.getCity()); 
	}

	
	public void view() {
         List<Employee> emplist=dao.viewAllEmp();
           
           for(Employee emp:emplist) {
        	   System.out.println("EID: "+emp.getId());
               System.out.println("EName: "+emp.getEname()); 
               System.out.println("Ecity :"+emp.getCity());
               System.out.println("Email :"+emp.getEmail());
               System.out.println("Salary :"+emp.getSalary()); 
           }
           }
	
	public void update() {
		List<Employee> emplist = dao.viewAllEmp();

	    int employeeIdToUpdate = 102;
	    Employee employeeToUpdate = null;
	    for (Employee emp : emplist) {
	        if (emp.getId() == employeeIdToUpdate) {
	            employeeToUpdate = emp;
	            break;
	        }
	    }

	    
	    if (employeeToUpdate != null) {
	        
	        Employee updatedEmployee = new Employee();
	        updatedEmployee.setId(employeeIdToUpdate); 
	        updatedEmployee.setEname("sai"); 
	        updatedEmployee.setCity("katy"); 
	        updatedEmployee.setEmail("sai@example.com"); 
	        updatedEmployee.setSalary(60000);  

	        dao.updateEmployee(updatedEmployee);

	        System.out.println("Employee with ID " + employeeIdToUpdate + " updated successfully!");
	    } else {
	        System.out.println("Employee with ID " + employeeIdToUpdate + " not found!");
	    }
	}
	




	
	
	public void viewOptions() {
		int option=0;
		
		do {
			System.out.println("1.Add employee details");
			System.out.println("2.Delete employee details");
			System.out.println("3.View employee details by employee id");
			System.out.println("4.view all employee details");
			System.out.println("5.Update employee details");
			System.out.println("6.exit");
			System.out.println("Enter the option :");
			option=sc.nextInt();
			if(option==1) {
				add();
			}
			else if(option==2) {
				delete();
			}
			else if(option==3) {
				id();
			}
			else if(option==4) {
				view();
			}
			else if(option==5) {
				update();
			}
		} while(option!=6);
		
	}
	
	
	
	 public static void main( String[] args )
	    {
	    	
	         App obj=new App();
	         
	         obj.viewOptions();
	
           } 
    }

