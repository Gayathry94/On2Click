package com.my_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Cart;

import com.my_project.Model.Registration;

@Repository
public interface Cart_Repo extends JpaRepository<Cart, Integer> {
	public List<Cart> findBycid(String cid);

}
