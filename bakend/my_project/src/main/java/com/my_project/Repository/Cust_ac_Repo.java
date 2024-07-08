package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Cust_Account;

@Repository
public interface Cust_ac_Repo extends JpaRepository<Cust_Account, String>
{

}
