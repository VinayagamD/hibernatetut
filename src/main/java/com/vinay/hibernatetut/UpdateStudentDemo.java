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
public class UpdateStudentDemo {

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
//			Create the student object
			System.out.println("Creating 3 student object.... ");
			Student student = new Student("Daffy","Duck","daffy@gmail.com");
//			start a transaction
			session.beginTransaction();
//			save the student object
			System.out.println("Saving the student... ");
			session.save(student);
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
//			My New Code
			
//			find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+student.getId());
			
//			now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve student based on the id: primary key
			System.out.println("Getting the student with id: "+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get Complete: "+myStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
