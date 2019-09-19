package com.origin.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.origin.web.Employee;
import com.origin.web.Expenses;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Integer> {
	List<Expenses> findByEmployee(Employee employee);
}
