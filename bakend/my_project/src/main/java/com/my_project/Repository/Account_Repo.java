package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Accounts;
import com.my_project.Model.Admin;

@Repository
public interface Account_Repo extends JpaRepository<Accounts, String>
{
	
}
