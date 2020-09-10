package com.innovationm.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class Test
{
	public static void main(String[] args) 
	{
		FileSystemXmlApplicationContext context1=new FileSystemXmlApplicationContext("beans.xml");
		HelloWorld hello=(HelloWorld)context1.getBean("helloWorld");  // here we using id form beans container
							// or
		//HelloWorld hello=context1.getBean(HelloWorld.class);
		hello.sayHello();
		Person p=context1.getBean(Person.class);
		System.out.println(p.toString());
		context1.close();
		@SuppressWarnings("resource")
		ApplicationContext context2=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student ab=context2.getBean(Student.class);
		System.out.println(ab.getName()+" "+ab.getHostel().getHostelName());
	}
}