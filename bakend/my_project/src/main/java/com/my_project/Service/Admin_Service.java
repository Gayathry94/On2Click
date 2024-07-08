package com.my_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_project.Model.Admin;
import com.my_project.Model.Complaints;
import com.my_project.Model.Pickup;
import com.my_project.Model.Products;
import com.my_project.Model.Querie;
import com.my_project.Model.Registration;
import com.my_project.Repository.Admin_Repo;
import com.my_project.Repository.Complaint_Repo;
import com.my_project.Repository.Pickup_Repo;
import com.my_project.Repository.Product_Repo;
import com.my_project.Repository.Querie_Repo;
import com.my_project.Repository.Reg_Repo;

import jakarta.servlet.http.HttpSession;

@Service
public class Admin_Service {
	@Autowired
	Admin_Repo ar;
@Autowired
Reg_Repo rp;
	@Autowired
	Pickup_Repo pr;
	@Autowired 
	Product_Repo pd;
	@Autowired 
	Complaint_Repo cr;
	@Autowired 
	Querie_Repo qr;
	public Admin adminAdd1(Admin admin) {
		
		return ar.save(admin);
	}



	public Admin logadmin(Admin a, HttpSession session) {
		Admin a1=ar.findByUname(a.getUname());
		if(a1.getPass().equals(a.getPass()))
		{
			session.setAttribute("aid",a1.getId());
			Integer adm=(Integer) session.getAttribute("aid");
			if(adm!=null)
			{
				System.out.println(adm);
				System.out.println("login sucess");
			}
			
			return a1;
		}
		else
		{
			System.out.println("Not a Valid User");
			return a1;
		}
		
		
	}



	public Pickup addpickup(Pickup p, HttpSession session) {
		int adm=(Integer) session.getAttribute("aid");
		if(adm!=0) {
			return pr.save(p);
		}
		else
		{
			return null;
		}
		
	}



	public List<Registration> viewprofile(String tc) {
		
		return rp.findByTc(tc);
	}



	public List<Products> viewprofile1(String type) {
		
		return pd.findByType(type);
	}



	public List<Complaints> viewcom() {
		
		return cr.findAll();
	}



	public List<Querie> viewque() {
		
		return qr.findAll();
	}
	

	
	
}
