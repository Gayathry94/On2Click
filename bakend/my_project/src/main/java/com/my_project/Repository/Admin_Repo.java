package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Admin;

@Repository
public interface Admin_Repo extends JpaRepository<Admin, Integer>{
    Admin findByUname(String u);


}
