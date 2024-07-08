package com.my_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.my_project.Model.Products;

import jakarta.transaction.Transactional;

@Repository
public interface Product_Repo extends JpaRepository<Products, Integer>
{
public  List<Products> findByType(String type);
public List<Products> findByCid(String cid);
public Products findById(int id);
}

