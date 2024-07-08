package com.my_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_project.Model.Admin;
import com.my_project.Model.Complaints;
import com.my_project.Model.Pickup;
import com.my_project.Model.Products;
import com.my_project.Model.Querie;
import com.my_project.Model.Registration;
import com.my_project.Service.Admin_Service;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/Admin")
@RestController
@CrossOrigin(origins = "*")
public class Admin_Main {
	@Autowired
	Admin_Service as;

	 @PostMapping("/addadmin")
	    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
	        Admin addedAdmin = as.adminAdd1(admin);
	        return new ResponseEntity<>(addedAdmin, HttpStatus.CREATED);
	    }
	 

	 @PostMapping("/login")
	 public Admin log(@RequestBody Admin a,HttpSession session)
	 {
		return as.logadmin(a,session);
		 
	 }
	 @PostMapping("/pickup")
	 public Pickup add(@ModelAttribute Pickup p,HttpSession session)
	 {
		return as.addpickup(p,session);
		 
	 }
	 @GetMapping("/Aviewprofile/{tc}")
	 public List<Registration> view(@PathVariable("tc") String tc)
	 {
		return as.viewprofile(tc);
		 
	 }
	 @GetMapping("/Aviewproduct/{type}")
	 public List<Products> view1(@PathVariable("type") String type)
	 {
		return as.viewprofile1(type);
		 
	 }
	 
	 @GetMapping("/viewcomplaint")
	 public List<Complaints> com()
	 {
		return as.viewcom();
		 
	 }
	 
	 @GetMapping("/viewquerie")
	 public List<Querie> queries()
	 {
		return as.viewque();
		 
	 }
}
