package com.my_project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Registration;

@Repository
public interface Reg_Repo extends JpaRepository<Registration, String> {
   

    public Registration findByUname(String u);

	public Registration findByCid(String cid);
	public List<Registration> findByTc(String type);

    


   
}
