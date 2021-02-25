package org.java.test.repository;

import java.util.List;

import org.java.test.model.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("repositorySim")
public interface RepositorySim extends JpaRepository<Sim, Integer> {

	@Query("select s from Sim s where s.customer.id =:id")
	public List<Sim> findByCustomerId(@Param("id")Integer id);
}
