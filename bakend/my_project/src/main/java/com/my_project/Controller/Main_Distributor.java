package com.my_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_project.Model.Accounts;
import com.my_project.Model.Distributor;
import com.my_project.Model.Login;
import com.my_project.Model.Vehicle;
import com.my_project.Service.Distributor_Service;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/Distributor")
@RestController
@CrossOrigin(origins = "*")
public class Main_Distributor {
	@Autowired
	Distributor_Service ds;
	@PostMapping("/Reg")
	public void addsd(@RequestBody Distributor d)
	{
		ds.addData(d);
	}
	@PostMapping("/Account")
	public void acc(@RequestBody Accounts a)
	{
		ds.getAcc(a);
	}
	@PostMapping("/Login")
	public void login(@RequestBody Login l, HttpSession session)
	{
		
		ds.getLogin(l,session);
	}
	 
	@PostMapping("/Regvehicle")
	public void regvehicle(@RequestBody Vehicle v,HttpSession session)
	{
		ds.addVehicle(v,session);
	}

}
