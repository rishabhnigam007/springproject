package SpringDataJpaProject;

import java.util.List;

public interface EmployeeService
{
	public abstract Employee createEmployee(Employee e);
	public abstract void updateEmployee(Employee e);
	public abstract Employee getEmployee(int id);
	public abstract List<Employee> getEmployees();
	public abstract void deleteEmployee(int id);
	public abstract boolean isEmployeeExist(int id);
}