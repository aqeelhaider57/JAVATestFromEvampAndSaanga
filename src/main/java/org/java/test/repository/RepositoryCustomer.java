package org.java.test.repository;

import java.time.LocalDate;
import java.util.List;

import org.java.test.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("repositoryCustomer")
public interface RepositoryCustomer extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c Where c.dateOfBirth BETWEEN :dateOfBirth AND :dateOfBirth ")
	public List<Customer> findByDateOfBirth(@Param("dateOfBirth") LocalDate dateOfBirth);
	
	//public List<Customer> findByDateOfBirth(LocalDate dateOfBirth);
}
