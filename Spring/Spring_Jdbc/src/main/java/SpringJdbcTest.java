import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJdbcTest 
{

	public static void main(String[] args)
	{
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/rishabh");
		dm.setUsername("root");
		dm.setPassword("1234");
		JdbcTemplate jt=new JdbcTemplate(dm);
		
		String sql="INSERT INTO user (id,username,password) VALUES (?,?,?)";
		int result=jt.update(sql, 1 ,"raj","1111");
		if(result>0)
			System.out.println("record inserted successfully !!");
		else
			System.out.println("failed !!");
	}

}
