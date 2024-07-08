package com.my_project.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_project.Model.Cart;
import com.my_project.Model.Preorder;
import com.my_project.Model.Products;
import com.my_project.Model.Purchase;
import com.my_project.Repository.Cart_Repo;
import com.my_project.Repository.Product_Repo;
import com.my_project.Repository.Purchase_Repo;
import com.my_project.Repository.Reg_Repo;
import com.my_project.Service.Cust_Service;

import com.my_project.Model.Registration;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class Main_Customer {
	@Autowired
	Cust_Service cs;
	
	@Autowired 
	Product_Repo pr;
	@Autowired
	Cart_Repo cr;
	@Autowired
	Reg_Repo rp;
	@Autowired
	Purchase_Repo pu;
	
	@GetMapping("/view/{type}/{cid}")
	public List<Products> view(@PathVariable("type") String type,@PathVariable("cid") String cid)
	{
		System.out.println(type);
		return cs.getall(type,cid);
		
	}
	@PostMapping("/preorder/{type}")
	public Preorder add(@RequestBody Preorder pr,@PathVariable("type") String type,HttpSession session)
	{
		return cs.preData(pr,type,session);
	}
	
	
	
	

	@GetMapping("/addcart/{cid}/{id}")
	public Cart addToCart(@PathVariable String cid, @PathVariable int id) {
	    Registration reg = rp.findByCid(cid);
	    Products product = pr.findById(id);
	    
	    // Create a new Cart object
	    Cart c = new Cart();
	    
	    // Set values for the Cart object
	    c.setCid(cid);
	    c.setId(id);
	    c.setName(product.getName());
	    c.setDes(product.getDes());
	    c.setPrice(product.getPrice());
	    c.setQuantity(product.getQuantity());
	    // Save the Cart object
	    return cr.save(c);
	}


	
	
	@GetMapping("/viewcart/{cid}")
	public List<Cart> viewCart(@PathVariable String cid)
	{
		return cs.viewCart(cid);
		
	}
	@DeleteMapping("/deletecartitem/{cid}/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String cid, @PathVariable Integer id) {
	    // Fetch the existing products from the database based on cid
	    List<Cart> existingProducts = cr.findBycid(cid);

	    // Check if the product list is not empty
	    if (!existingProducts.isEmpty()) {
	        // Find the product with the matching id
	        for (Cart existingProduct : existingProducts) {
	        	 if (Integer.valueOf(existingProduct.getId()).equals(id)) {
	                // Delete the product from the database
	                cr.delete(existingProduct);
	                return ResponseEntity.ok("Product with ID " + id + " deleted successfully.");
	            }
	        }
	    }

	    // If the product with the provided cid or id does not exist
	    throw new RuntimeException("Product not found or not deleted.");
	}
	
	
	@PostMapping("/buy/{cid}")
	public Purchase buyProducts(@PathVariable String cid, @RequestBody List<Cart> requestData) {
	    int total = 0;
	    for (Cart item : requestData) {
	        int productId = item.getId();
	        int quantity = item.getQuantity();
	        Products product = pr.findById(productId);
	        total += product.getPrice() * quantity;
	        product.setQuantity(product.getQuantity() - quantity);
	        pr.save(product);
	        cr.delete(item);
	    }
	    
	    Purchase purchase = new Purchase();
	    purchase.setCid(cid);
	    purchase.setTotal(total);
	    String formattedTime = LocalTime.now().toString().substring(0, 5).replace(":", ".").trim();
	    purchase.setDate(LocalDate.now().toString());
	    purchase.setTime(formattedTime); 
	    Purchase savedPurchase = pu.save(purchase);
	   
	    return savedPurchase;
	}

	@GetMapping("/orders/{cid}")
	public List<Purchase> ViewCart(@PathVariable String cid)
	{
		return pu.findBycid(cid);
		
	}
}