package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Customer;
@Repository
public interface Cust_Repo extends JpaRepository<Customer, String>{
	@Query(value = "SELECT MAX(id) FROM Registration")
    String findMaxId();
	public Customer findByUname(String s);

}
