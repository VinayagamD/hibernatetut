/**
 * 
 */
package com.vinay.hibernatetut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;

/**
 * @author Dell
 *
 */
public class ReadStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//			create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
//			find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+studentId);
			
//			now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve student based on the id: primary key
			System.out.println("Getting the student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student....");
			myStudent.setFirstName("Scooby");
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
