package net.crudjava.springboot.controller;

import net.crudjava.springboot.model.Employee;
import net.crudjava.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);

    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> GetEmployee(@PathVariable long id){


        return service.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable long id){


        return service.updateEmployee(employee,id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id){


        return service.deleteEmployee(id);
    }
}
