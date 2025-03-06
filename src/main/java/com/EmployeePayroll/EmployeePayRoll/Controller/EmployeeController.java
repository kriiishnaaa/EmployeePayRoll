package com.EmployeePayroll.EmployeePayRoll.Controller;

import com.EmployeePayroll.EmployeePayRoll.Model.Employee;
import com.EmployeePayroll.EmployeePayRoll.Repository.EmployeeRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
private final EmployeeRepository employeeRepository;
public EmployeeController(EmployeeRepository employeeRepository){
    this.employeeRepository=employeeRepository;
}
@GetMapping()
    public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
}
@GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
    return employeeRepository.findById(id).orElse(null);
}
@PostMapping
public Employee createEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
}
@PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
    return employeeRepository.findById(id).map(employee -> {
        employee.setName(updatedEmployee.getName());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(employee);
    }).orElse(null);
}

@DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
    employeeRepository.deleteById(id);
}
}
