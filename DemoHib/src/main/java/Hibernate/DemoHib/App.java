package Hibernate.DemoHib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf=con.buildSessionFactory();
        Session s=sf.openSession();
          
        Scanner sc=new Scanner(System.in);
        System.out.println("1. insert data :");
        System.out.println("2. fetch data :");
        System.out.print("enter choice :");
        int choice=sc.nextInt();
        System.out.println();
        switch(choice)
        {
        	case 1:  
        		AlienName an=new AlienName();
        		System.out.println("enter first name :");
        		String fname=sc.next();
            	an.setFname(fname);
            	System.out.println("enter middle name :");
        		String mname=sc.next();
            	an.setMname(mname);
            	System.out.println("enter last name :");
        		String lname=sc.next();
            	an.setLname(lname);
            	sc.nextLine();
                Alien a=new Alien();
                System.out.println("enter id :");
                int id=sc.nextInt();
                a.setAid(id);
                a.setAname(an);
                System.out.println("enter color :");
                String color=sc.next();
                a.setColor(color);
                
                Transaction t=s.beginTransaction();
                s.save(a);
                if(s!=null)
                	System.out.println("Record inserted successfully");
                t.commit();
                break;
        	case 2:
        		System.out.println("enter id :");
        		int id1=sc.nextInt();
        		a=s.get(Alien.class, id1);
        		System.out.println(a);
        		break;
        	default :
        		System.out.println("invalid choice !!");
        		System.exit(0);
        }
        sc.close();
    }
}