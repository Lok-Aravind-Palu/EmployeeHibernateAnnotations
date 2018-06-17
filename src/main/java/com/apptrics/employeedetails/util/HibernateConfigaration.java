package com.apptrics.employeedetails.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apptrics.employeedetails.pojo.EmployeePOJO;

public class HibernateConfigaration {

	public static void insertValues() {

		try{
			Session sesion = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = sesion.beginTransaction();

			EmployeePOJO emp = new EmployeePOJO();
			emp.setEmployeeName("Yash");
			emp.setEmployeeId(1);
			emp.setEmployeeDept("ECE");
			emp.setEmployeeSalary(500);
			
			sesion.save(emp);
			transaction.commit();
			
			
		}catch(Exception e){
			
		}
	}

	public static void readValues() {
		
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Criteria createCriteria = session.createCriteria(EmployeePOJO.class);
			List<EmployeePOJO> list = createCriteria.list();
			
			list.forEach(item->{
				System.out.println(item.toString());
			});
			
		}catch(Exception e){
			
		}
	}

}
