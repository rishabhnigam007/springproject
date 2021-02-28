package hibernate.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		Employee e=new Employee();
		e.setEid(100);
		e.setEname("risu");
		e.setEsalary(4600);
		s.save(e);
		s.getTransaction().commit();
		s.detach(e);
		e.setEsalary(5000);
		s.close();
		System.out.println();
		System.out.println("For fetching record :");
		System.out.println();
		
		Session s1=sf.openSession();
		s1.beginTransaction();
		
		// load will inhance performance because query hit when object is use otherwise not
		// get will give object
		// load will give proxy object means when use object then only query fire
		
		
		Employee e1=s1.load(Employee.class, 1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(e1);
		
		s1.getTransaction().commit();
		s1.close();
	}
}