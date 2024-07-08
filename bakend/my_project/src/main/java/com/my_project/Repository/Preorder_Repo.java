package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_project.Model.Preorder;

@Repository
public interface Preorder_Repo extends JpaRepository<Preorder, Integer>
{

}
