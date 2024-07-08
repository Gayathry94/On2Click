package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Querie;

@Repository
public interface Querie_Repo extends JpaRepository<Querie, Integer>{

}
