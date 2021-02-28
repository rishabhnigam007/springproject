package hibernate.mappings;

import org.hibernate.Query;

//import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class App {
	public static void main(String[] args) 
	{
		Alien a=null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = con.buildSessionFactory();
//		Session s = sf.openSession();
//		s.beginTransaction();
		
		// first level cache which is work for a perticular session
		
		// second level cache for add two dependencies hibernate-ecache and net.sf.ecache then setting hibernate file .
		// with two properties name - hibernate.cache.use_second_level_cache set to true and another property is name hibernate region factory class path
		
		Session s1=sf.openSession();
		s1.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query q1=s1.createQuery("from Alien where aid=101");
		q1.setCacheable(true);
		a=(Alien)q1.uniqueResult();
		System.out.println(a);
		s1.getTransaction().commit();
		s1.close();
		
		Session s2=sf.openSession();
		s2.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query q2=s2.createQuery("from Alien where aid=101");
		q2.setCacheable(true);
		a=(Alien)q2.uniqueResult();
		//a=s2.get(Alien.class, 103);
		System.out.println(a);		
		s2.getTransaction().commit();
		s2.close();
		
		//s.getTransaction().commit();
		//s.close();
	}
}