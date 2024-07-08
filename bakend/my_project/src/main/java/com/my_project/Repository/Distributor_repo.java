package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Distributor;

@Repository
public interface Distributor_repo extends JpaRepository<Distributor, String>
{
	 @Query(value = "SELECT MAX(id) FROM Distributor")
	    String findMaxId();
	 public Distributor findByUname(String u);
	// public Distributor findById(int i);
}
