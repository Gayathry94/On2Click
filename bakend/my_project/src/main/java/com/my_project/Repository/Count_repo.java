package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Reg_count;
@Repository
public interface Count_repo extends JpaRepository<Reg_count, Integer> {

	

	

}
