package SpringDataJpaProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplimentation implements EmployeeService 
{
	@Autowired
	private EmployeeRepository er;

	@Override
	public Employee createEmployee(Employee e) 
	{
		return er.save(e);
	}

	@Override
	public void updateEmployee(Employee e) 
	{
		er.save(e);
	}

	@Override
	public Employee getEmployee(int id)
	{
		Optional<Employee> o=er.findById(id);
		Employee e=o.get();
		return e;
	}

	@Override
	public List<Employee> getEmployees()
	{
		return (List<Employee>)er.findAll();
	}

	@Override
	public void deleteEmployee(int id) 
	{
		er.deleteById(id);
	}

	@Override
	public boolean isEmployeeExist(int id) 
	{
		return er.existsById(id);
	}
	

}
