package com.my_project.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_project.Model.Cart;
import com.my_project.Model.Cust_Account;

import com.my_project.Model.Cust_count;
import com.my_project.Model.Login;
import com.my_project.Model.Preorder;
import com.my_project.Model.Products;
import com.my_project.Model.Customer;
import com.my_project.Repository.Cart_Repo;
import com.my_project.Repository.Cust_Count_Repo;
import com.my_project.Repository.Cust_Repo;
import com.my_project.Repository.Cust_ac_Repo;
import com.my_project.Repository.Login_Repo;
import com.my_project.Repository.Preorder_Repo;
import com.my_project.Repository.Product_Repo;
import com.my_project.Repository.Reg_Repo;

import com.my_project.Model.Registration;
import jakarta.servlet.http.HttpSession;



@Service
public class Cust_Service {
	
	@Autowired
	Product_Repo pr;
	@Autowired
	Preorder_Repo pe;
	@Autowired
	Reg_Repo rp;
	@Autowired 
	Cart_Repo cr;
public List<Products> getall(String type,String cid) {
	
	if(cid!=null && type!=null)
	{
		List<Products> p=pr.findByType(type);
		return p;
	}
	else
	{
		return null;
	}
		
		
		
		
	}

public Preorder preData(Preorder pr2, String type,HttpSession session) {
	
String custid= (String) session.getAttribute("cid");
if(custid!=null)
{
	//LocalTime time1 = pr2.getTime();
	//String formattedTime1 = time1.toString().substring(0, 5).replace(":", ".").trim();
	//pr2.setTime(LocalTime.parse(formattedTime1));
	pr2.setCid(custid);
	pr2.setStatus("Active");
	
	return pe.save(pr2);
}
else
{
	return null;
}
}

public List<Cart> viewCart(String cid) {
	
	List<Cart> ca=cr.findBycid(cid);
	
	
	return ca;
}

	




}
