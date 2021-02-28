package hibernate.mappings;

//import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) 
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Alien a1=s.get(Alien.class,3);
		System.out.println(a1.getAname());
		
		//for one alien have multiple laptop then it will give all record of one alien with no of laptop
//		Collection<Laptop> laps=a1.getLaps();
//		
//		for(Laptop l: laps)
//		{
//			System.out.println(l);
//		}
		
		s.getTransaction().commit();
		//s.close();
	}
}