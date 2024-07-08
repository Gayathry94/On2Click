package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Vehicle;

@Repository
public interface Vehicle_Repo extends JpaRepository<Vehicle, Integer>
{

}
