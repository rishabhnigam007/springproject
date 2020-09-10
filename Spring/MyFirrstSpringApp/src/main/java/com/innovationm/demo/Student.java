package com.innovationm.demo;
public class Student 
{
	private String name;
	private String Id;
	private Hostel hostel;
	// this attribute is define in bean with ref attribute and if i forget this
	//   property to mension in bean file then resolve this error using autowiring
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getId() 
	{
		return Id;
	}
	public void setId(String id) 
	{
		Id = id;
	}
	public Hostel getHostel() {
		return hostel;
	}
	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}	
}