/**
 * 
 */
package com.vinay.hibernatetut;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;

/**
 * @author Dell
 *
 */

public class QueryStudentDemo {

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
			System.out.println("Creating new studnet object.... ");
//			start transaction
			session.beginTransaction();
//			query students
			List<Student> students = session.createQuery("FROM Student").list();
//			display students
			displayStudents(students);
			
//			query students: lastName='Doe'
			students = session.createQuery("from Student s where s.lastName='Duck'").list();
			
//			display students
			System.out.println("\n\n Students who have last name of Duck");
			displayStudents(students);
			
//			query students: lastName='Doe' OR firstName='Daffy'
			students = session.createQuery("from Student s where "
					+ " s.lastName='Doe' OR s.firstName='Daffy'").list();
			
//			display students
			System.out.println("\n\n Students who have last name of Doe OR first name Daffy");
			displayStudents(students);
			
//			query students WHERE email LIKE '%gmail.com'
			students = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'").list();
			
//			display students
			System.out.println("\n\n Students who have email LIKE gmail.com");
			displayStudents(students);
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		students.forEach(System.out::println);
	}

}
