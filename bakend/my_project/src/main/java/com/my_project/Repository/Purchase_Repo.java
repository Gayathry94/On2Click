package com.my_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Purchase;

@Repository
public interface Purchase_Repo extends JpaRepository<Purchase, Integer>
{

	public List<Purchase> findBycid(String cid);

}
