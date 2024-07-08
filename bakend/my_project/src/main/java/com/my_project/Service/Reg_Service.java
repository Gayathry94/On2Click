package com.my_project.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.my_project.Model.Accounts;
import com.my_project.Model.ImageModel;
import com.my_project.Model.Login;
import com.my_project.Model.Products;
import com.my_project.Model.Querie;
import com.my_project.Model.Reg_count;
import com.my_project.Model.Registration;

import com.my_project.Repository.Account_Repo;
import com.my_project.Repository.Count_repo;
import com.my_project.Repository.ImageModelRepository;
import com.my_project.Repository.Login_Repo;
import com.my_project.Repository.Product_Repo;
import com.my_project.Repository.Querie_Repo;
import com.my_project.Repository.Reg_Repo;


import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Service

public class Reg_Service {

	  @Autowired
	  ImageModelRepository imageModelRepository;
	@Autowired
	Reg_Repo rp;
	@Autowired
	Count_repo cr;
	@Autowired
	Account_Repo ar;
	@Autowired
	Login_Repo lr;
	@Autowired
	Product_Repo pr;
	@Autowired
	Querie_Repo qr;
		public void addf(Registration r,HttpSession ses) {
			String str="FAR";
			Reg_count rc=new Reg_count();
			Reg_count rc1=cr.save(rc);
			String str1=String.valueOf(rc1.getId());
			String str2=str.concat(str1);
			r.setCid(str2);
			
			
			String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
		      r.setDate(LocalDate.now().toString());
		      r.setTime(formattedTime); 
		      rp.save(r);
		      ses.setAttribute("reguser", r.getCid()); 
		      
		     
		      
		 
			
		}
	public void adda(Registration r,HttpSession ses) {
			
		String str="ART";
		Reg_count rc=new Reg_count();
		Reg_count rc1=cr.save(rc);
		String str1=String.valueOf(rc1.getId());
		String str2=str.concat(str1);
		r.setCid(str2);
		rp.save(r);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      r.setDate(LocalDate.now().toString());
	      r.setTime(formattedTime); 
	      rp.save(r);
	      ses.setAttribute("reguser", r.getCid()); 
		}
	
	public void addc(Registration r,HttpSession ses) {
		
		
		String str="CON";
		Reg_count rc=new Reg_count();
		Reg_count rc1=cr.save(rc);
		String str1=String.valueOf(rc1.getId());
		String str2=str.concat(str1);
		r.setCid(str2);
		rp.save(r);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      r.setDate(LocalDate.now().toString());
	      r.setTime(formattedTime); 
	      rp.save(r);
	      ses.setAttribute("reguser", r.getCid()); 
	}
	public void addd(Registration r,HttpSession ses) {
		
		String str="DES";
		Reg_count rc=new Reg_count();
		Reg_count rc1=cr.save(rc);
		String str1=String.valueOf(rc1.getId());
		String str2=str.concat(str1);
		r.setCid(str2);
		rp.save(r);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      r.setDate(LocalDate.now().toString());
	      r.setTime(formattedTime); 
	      rp.save(r);
	      ses.setAttribute("reguser", r.getCid()); 
	}
	public void addcu(Registration r, HttpSession ses) {
		String str="CUS";
		Reg_count rc=new Reg_count();
		Reg_count rc1=cr.save(rc);
		String str1=String.valueOf(rc1.getId());
		String str2=str.concat(str1);
		r.setCid(str2);
		rp.save(r);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      r.setDate(LocalDate.now().toString());
	      r.setTime(formattedTime); 
	      rp.save(r);
	      ses.setAttribute("reguser", r.getCid()); 
		
	}
	public void addis(Registration r, HttpSession ses) {
		String str="DIS";
		Reg_count rc=new Reg_count();
		Reg_count rc1=cr.save(rc);
		String str1=String.valueOf(rc1.getId());
		String str2=str.concat(str1);
		r.setCid(str2);
		rp.save(r);
		String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	      r.setDate(LocalDate.now().toString());
	      r.setTime(formattedTime); 
	      rp.save(r);
	      ses.setAttribute("reguser", r.getCid()); 
		
		
	}
	

    

	public Login getLog(Login l, HttpSession session) {
		
		
		
	    Registration r = rp.findByUname(l.getUname());
	    
	    if (r != null && r.getPass().equals(l.getPass())) {
	    	
	        String id = r.getCid();
	        if (id.length() >= 3) {
	            switch (id.substring(0, 3)) {
	                case "FAR":
	                    l.setRole("Farmer");
	                    break;
	                case "ART":
	                    l.setRole("Artisan"); 
	                    break;
	                case "CON":
	                    l.setRole("Confectioner");
	                    break;
	                case "DES":
	                    l.setRole("Designer");
	                    break;
	                case "CUS":
	                    l.setRole("Customer");
	                    break;
	                case "DIS":
	                    l.setRole("Distributor");
	                    break;
	                default:
	                    return null;
	            }
	        }
	        l.setCid(id);
	        String formattedTime1 = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	        l.setDate(LocalDate.now().toString());
	        l.setTime(formattedTime1);
	        lr.save(l);
	       // session.setAttribute("currentuser", l); 
		  // Login currentUser = (Login) session.getAttribute("currentuser");

	       session.setAttribute("currentuser", l.getCid()); 
	       String currentUser = (String) session.getAttribute("currentuser");
	        if (currentUser != null) {
	            System.out.println(currentUser);
	            System.out.println("success");
	        } else {
	            System.out.println("Unable to retrieve current user from the session");
	        }
	        
	        System.out.println("login success");
	        return l; 
	    }
	    else {
	        System.out.println("Please check login credentials");
	        return null; 
	    }
	    
	    
	}
	
	
	public Products addNewProduct(Products product) {
        Integer maxlid = lr.findMaxlId();

        if (maxlid != null) {
            String cid = lr.findCidById(maxlid);

            if (cid != null) {
                String st = "active";
                String type = "";

                if (cid.startsWith("FAR")) {
                    type = "Farms";
                } else if (cid.startsWith("CON")) {
                    type = "Confection";
                } else if (cid.startsWith("ART")) {
                    type = "Artisan";
                } else if (cid.startsWith("DES")) {
                    type = "Design";
                } else {
                    System.out.println("Not a Valid User");
                    return null;
                }

                product.setType(type);
                product.setCid(cid);
                product.setStatus(st);

                return pr.save(product);
            } else {
                System.out.println("No CID found for max ID");
                return null;
            }
        } else {
            System.out.println("No records found in login table.");
            return null;
        }
    }
	    
	public List<Products> viewProd() {
		
		return pr.findAll();
	}
	public Querie addQuerie(Querie q) {
		return qr.save(q);
		
	}
	

	
	

}