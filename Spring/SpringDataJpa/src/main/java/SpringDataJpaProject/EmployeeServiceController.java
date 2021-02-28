package SpringDataJpaProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Transactional
public class EmployeeServiceController
{
	@Autowired(required=true)
	private EmployeeService es;
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee e)
	{
		e=es.createEmployee(e);
		return new ResponseEntity<>("employee is created successfully "+e.getId(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee e)
	{
		boolean isEmployeeExist =es.isEmployeeExist(id);
		if(isEmployeeExist)
		{
			e.setId(id);
			es.updateEmployee(e);
			return new ResponseEntity<>("employee is updated successfully",HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}
	}
	
	@RequestMapping(value = "/employees/{id}", method =RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist =es.isEmployeeExist(id);
		if(isEmployeeExist)
		{
			Employee e=es.getEmployee(id);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees()
	{
		List<Employee> el=es.getEmployees();
		return new ResponseEntity<>(el,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist =es.isEmployeeExist(id);
		if(isEmployeeExist)
		{
			es.deleteEmployee(id);
			return new ResponseEntity<>("employee is deleted successfully",HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}
	}
	
}
