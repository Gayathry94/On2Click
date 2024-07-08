package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Login;


@Repository
public interface Login_Repo extends JpaRepository<Login, Integer>
{
	 @Query(value = "SELECT MAX(lid) FROM Login")
	    Integer findMaxlId();

	    @Query(value = "SELECT cid FROM Login WHERE lid = ?1")
	    String findCidById(Integer lid);

	    Login findByCid(String u);


}
