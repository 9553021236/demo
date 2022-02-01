package net.crudjava.springboot.service;

import net.crudjava.springboot.model.Employee;
import net.crudjava.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Add Employee(Post)
    public String addEmployee(Employee employee){
        employeeRepository.save(employee);

        return "Employee Created!!";
    }

    //Show Employee(Get)
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //Show Employee by ID(Get)
    public Optional<Employee> getEmployee(long id){
        Optional<Employee> temp=employeeRepository.findById(id);
        if(temp.isPresent())
            return employeeRepository.findById(id);
        else
            throw new NoSuchElementException("EMPLOYEE NOT FOUND!!");
    }

    //Delete Employee(Delete)
    public String deleteEmployee(long id){
        Optional<Employee> temp=employeeRepository.findById(id);
        if(temp.isPresent()) {
            employeeRepository.deleteById(id);
            return "PRODUCT REMOVED!!";
        }
        else
            throw new NoSuchElementException("NO EMPLOYEE FOUND!!");
    }

    //Update Employee(Put)
    public String updateEmployee(Employee employee,long id){
        Optional<Employee> temp=employeeRepository.findById(id);
        if (temp.isPresent()){
            Employee e=employeeRepository.getById(id);
            String s="";
            if(!e.getFirstName().equals(employee.getFirstName())){
                e.setFirstName(employee.getFirstName());
                employeeRepository.save(e);
                s="Updated First_Name.\n";
            }
            if(!e.getLastName().equals(employee.getLastName())){
                e.setLastName(employee.getLastName());
                employeeRepository.save(e);
                s=s+"Updated Last_Name.\n";
            }
            if(!e.getEmailId().equals(employee.getEmailId())){
                e.setEmailId(employee.getEmailId());
                employeeRepository.save(e);
                s=s+"Updated EmailId.";
            }
            return s;

        }
        else
            throw new NoSuchElementException("Employee Not Found");
    }


}
