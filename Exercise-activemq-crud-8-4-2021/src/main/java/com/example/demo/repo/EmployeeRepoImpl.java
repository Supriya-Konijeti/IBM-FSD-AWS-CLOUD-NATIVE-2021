package com.example.demo.repo;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Service
public abstract class EmployeeRepoImpl implements EmployeeRepo {
    private EmployeeRepo employeeRepo;
    private Map<Integer, Employee> employeeMap;
    {
        employeeMap=new HashMap<Integer, Employee>();
        employeeMap.put(1, new Employee(UUID.randomUUID().toString(), "John", "Doe", "john@email.com"));
        employeeMap.put(2, new Employee(UUID.randomUUID().toString(), "Marry", "Public", "marry@email.com"));
        employeeMap.put(3, new Employee(UUID.randomUUID().toString(), "Rahul", "Dravid", "rahul@email.com"));
        employeeMap.put(4, new Employee(UUID.randomUUID().toString(), "Sourav", "Ganguly", "sourav@email.com"));
    }
    @Override
    public Collection<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeMap.values();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        // TODO Auto-generated method stub
        Employee employee=employeeMap.get(id);
        if(employee==null)
        {
            throw new EmployeeNotFoundException("no such employee found");
        }
        return employee;
    }
    @Override
    public Employee createEmployee(Employee employee) {
    	employee.setEmployeeId(UUID.randomUUID().toString());  		
        employeeMap.put(employeeMap.size()+1,employee);
        return employee;
    }
    @Override
    public void deleteEmployee(Integer id){
        Employee employee=employeeMap.get(id);
        if(employee==null){
            throw new EmployeeNotFoundException("no such employee found");
        }else{
        employeeMap.remove(id);
    }
    }
    @Override
    public Employee updateEmployee(Integer id,Employee employee) {
        Employee tempEmployee=employeeMap.get(id);
        if(tempEmployee==null)
        {
            throw new EmployeeNotFoundException("no employee found with the given id: "+id);
        }
        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        tempEmployee.setEmail(employee.getEmail());
        employeeMap.remove(id);
        employeeMap.put(id, tempEmployee);
        return tempEmployee;
    }


	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		employeeMap.remove(employeeMap.size()-1);
	}

}
