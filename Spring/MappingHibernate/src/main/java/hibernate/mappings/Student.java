package hibernate.mappings;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	private int rollno;
	private int marks;
	private String name;
	
	@OneToOne
	private Laptop laptop;
	
	public Laptop getLaptop() {	return laptop;	}
	public void setLaptop(Laptop laptop) {	this.laptop = laptop;	}	
	public int getRollno() {return rollno;	}
	public void setRollno(int rollno) {	this.rollno = rollno;	}
	public int getMarks() {	return marks;	}
	public void setMarks(int marks) {this.marks = marks;	}
	public String getName() {return name;	}
	public void setName(String name) {this.name = name;	}
	@Override
	public String toString() {return "Student [rollno=" + rollno + ", marks=" + marks + ", name=" + name + ", laptop=" + laptop + "]";}
}