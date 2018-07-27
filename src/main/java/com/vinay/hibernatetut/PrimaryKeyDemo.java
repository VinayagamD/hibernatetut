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
public class PrimaryKeyDemo {

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
			Student student = new Student("Vinay","Ganesh","vinayganeshdxj@gmail.com");
//			start a transaction
			session.beginTransaction();
//			save the student object
			System.out.println("Saving the student... ");
			session.save(student);
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
		}finally {
			factory.close();
		}
	}

}
