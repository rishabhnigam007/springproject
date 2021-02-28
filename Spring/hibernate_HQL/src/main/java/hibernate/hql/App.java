package hibernate.hql;

import java.util.List;

import org.hibernate.Query;

//import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class App
{
	public static void main(String[] args) 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
//		for inserting data ia a database
//		Random r=new Random();
//		for(int i=1;i<=20;i++)
//		{
//			Student stu=new Student();
//			stu.setRollno(i);
//			stu.setName("Name "+i);
//			stu.setMarks(r.nextInt(100));
//			s.save(stu);
//		}
		
		// for retrieving data into database
		System.out.println("print with with of student :");
		@SuppressWarnings({ "rawtypes" })
		Query q1 = s.createQuery("from Student where marks>70");
		@SuppressWarnings({ "unchecked" })
		List<Student> l = q1.list();
		for (Student stu : l) 
		{
			System.out.println(stu);
		}
		
		// for unique result so no need to iterate simply type cast to class name and print
		System.out.println();
		System.out.println("print with only unique value :");
		q1 = s.createQuery("from Student where rollno=7");
		Student stud = (Student) q1.uniqueResult();
		System.out.println(stud);
		System.out.println();
		System.out.println("print with column name :");
		@SuppressWarnings("rawtypes")
		Query q2=s.createQuery("select rollno,marks,name from Student");
		@SuppressWarnings("unchecked")
		List<Object[]> list=q2.list();
		for(Object[] o:list)
		{
			System.out.println("Roll NO.="+o[0]+" : Marks="+o[1]+" : Name="+o[2]);
		}
			
		@SuppressWarnings("rawtypes")
		Query q3=s.createQuery("select avg(marks) from Student");
		Double mark=(Double)q3.uniqueResult();
		System.out.println("Average Marks :"+mark);
		
		int b=70;
		@SuppressWarnings("rawtypes")
		//Query q4=s.createQuery("select max(marks) from Student s where s.marks>"+b);
		//or
		Query q4=s.createQuery("select max(marks) from Student s where s.marks > :b");
		q4.setParameter("b", b);    // this is called position parameter
		Integer mark1=(Integer)q4.uniqueResult();
		System.out.println("Maximum marks :"+mark1);
		
		s.getTransaction().commit();
		s.close();
	}
}