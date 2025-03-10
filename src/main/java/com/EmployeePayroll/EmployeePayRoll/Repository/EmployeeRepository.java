package com.EmployeePayroll.EmployeePayRoll.Repository;

import com.EmployeePayroll.EmployeePayRoll.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
