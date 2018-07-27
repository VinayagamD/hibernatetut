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
public class CreateStudentDemo {

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
			Student student1 = new Student("John","Doe","john@gmail.com");
			Student student2= new Student("Marry","Public","mary@gmail.com");
			Student student3 = new Student("Bnita","Applebaum","bonita@gmail.com");
//			start a transaction
			session.beginTransaction();
//			save the student object
			System.out.println("Saving the student... ");
			session.save(student1);
			session.save(student2);
			session.save(student3);
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
		}finally {
			factory.close();
		}
	}

}
