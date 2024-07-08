package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Pickup;

@Repository
public interface Pickup_Repo extends JpaRepository<Pickup, Integer> 
{

}
