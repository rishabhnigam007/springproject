package hibernate.mappings;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();

		Laptop laptop = new Laptop();
		System.out.println("enter laptop id :");
		int lid = sc.nextInt();
		laptop.setLid(lid);
		System.out.println("enter laptop name :");
		String lname = sc.next();
		laptop.setLname(lname);

		s.save(laptop);
		
		Student student = new Student();
		System.out.println("enter student rollno :");
		int srollno = sc.nextInt();
		student.setRollno(srollno);
		System.out.println("enter student marks :");
		int smarks = sc.nextInt();
		student.setMarks(smarks);
		System.out.println("enter student name :");
		String sname = sc.next();
		student.setName(sname);
		student.setLaptop(laptop);
		
		s.beginTransaction();
		s.save(student);
		System.out.println(student);
		s.getTransaction().commit();
		sc.close();
	}
}