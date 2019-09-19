package com.origin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.origin.web.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByNameAndAddress(String name, String address);

	Employee findByUserNameAndPwd(String userName, String pwd);

}
