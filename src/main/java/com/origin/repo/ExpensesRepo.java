package com.origin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.origin.web.Expenses;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Integer> {

}
