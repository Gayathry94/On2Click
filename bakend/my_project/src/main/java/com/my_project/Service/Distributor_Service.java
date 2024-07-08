package com.my_project.Service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_project.Model.Accounts;
import com.my_project.Model.Distributor;
import com.my_project.Model.Login;
import com.my_project.Model.Reg_count;
import com.my_project.Model.Vehicle;
import com.my_project.Repository.Account_Repo;
import com.my_project.Repository.Count_repo;
import com.my_project.Repository.Distributor_repo;
import com.my_project.Repository.Login_Repo;
import com.my_project.Repository.Vehicle_Repo;

import jakarta.servlet.http.HttpSession;

@Service
public class Distributor_Service {
@Autowired
Distributor_repo dr;
@Autowired 
Count_repo cr;
@Autowired
Account_Repo ar;
@Autowired
Login_Repo lr;
@Autowired 
Vehicle_Repo vr;
	public void addData(Distributor d) {
		Reg_count r=new Reg_count();
		Reg_count rc=cr.save(r);
		String str1="DIS";
		String str2=String.valueOf(rc.getId());
		String Str=str1.concat(str2);
		d.setId(Str);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      d.setDate(LocalDate.now().toString());
	      d.setTime(formattedTime); 
		
		
		dr.save(d);
		
	}
	public void getAcc(Accounts a) {
		
		String Maxid=dr.findMaxId();
		if (Maxid != null) {
			 a.setId(Maxid);
	            
	            ar.save(a);
	        } 
	}
	public Login getLogin(Login l, HttpSession session) {
		Distributor d=dr.findByUname(l.getUname());
		if(d!=null && d.getPass().equals(l.getPass()))
		{
			String id = d.getId();
			l.setCid(id);
			l.setRole("Distributor");
			 String formattedTime1 = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
		        l.setDate(LocalDate.now().toString());
		        l.setTime(formattedTime1);
		        lr.save(l);
		        
		        session.setAttribute("Did", l.getCid()); 
			       String currentUser = (String) session.getAttribute("Did");
			        if (currentUser != null) {
			            System.out.println(currentUser);
			            System.out.println("success");
			        } else {
			            System.out.println("Unable to retrieve current user from the session");
			        }
			        
			        System.out.println("login success");
			        return l; 
			    }
		        
		        
			
		
		else
		{
			System.out.println("Invalid login Credentials");
			return null;
		}
		
		
	}
	public void addVehicle(Vehicle v,HttpSession session) {
		
		String currentUser = (String) session.getAttribute("Did");
        if (currentUser != null) {
            System.out.println(currentUser);
            v.setDid(currentUser);
            String formattedTime1 = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	        v.setDate(LocalDate.now().toString());
	        v.setTime(formattedTime1);
	        vr.save(v);
            System.out.println("success");
        } else {
            System.out.println("Unable to retrieve current user from the session");
        }
        
		
	}
	
	
	

}
