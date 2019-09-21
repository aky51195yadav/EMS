package com.origin.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.origin.web.Employee;
import com.origin.web.Expenses;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Integer> {

	Optional<List<Expenses>> findAllByEmployee(Employee employee);

	Optional<Expenses> findAmountByEmployee(Employee emp);

	Optional<Expenses> findByamount(Employee emp);

	//Optional<Expenses> findBillAmount(Employee empdata);

}
