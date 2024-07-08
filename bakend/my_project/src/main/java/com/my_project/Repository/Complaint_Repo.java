package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Complaints;

@Repository
public interface Complaint_Repo extends JpaRepository<Complaints, Integer>{

	
	
	
}
