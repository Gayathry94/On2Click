package com.my_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_project.Model.ImageModel;

public interface ImageModelRepository extends JpaRepository<ImageModel, Integer> {
	
	

}
