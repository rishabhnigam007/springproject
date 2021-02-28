package hibernate.hsql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class App {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		// Native Queries
		
		// this is the way to fetch entire row in a table
		SQLQuery stu=s.createSQLQuery("select * from Student where marks>70");
		stu.addEntity(Student.class);
		List<Student> l=stu.list();
		
		for(Student s1:l)
		{
			System.out.println(s1);  
		}
		
		System.out.println("print with specific column :");
		
		stu=s.createSQLQuery("select name,marks from Student where marks>60");
		stu.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List stu1=stu.list();
		for(Object o:stu1)
		{
			Map m=(Map)o;
			System.out.println(m.get("name")+":"+m.get("marks"));
		}
		
		s.getTransaction().commit();
		s.close();

	}

}
