package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Cust_count;

@Repository

public interface Cust_Count_Repo extends JpaRepository<Cust_count, Integer>
{


}
