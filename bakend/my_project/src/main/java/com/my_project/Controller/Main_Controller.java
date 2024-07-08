package com.my_project.Controller;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.my_project.Model.Accounts;
import com.my_project.Model.Complaints;
import com.my_project.Model.ImageModel;
import com.my_project.Model.Login;
import com.my_project.Model.Products;
import com.my_project.Model.Querie;
import com.my_project.Model.Registration;

import com.my_project.Repository.Account_Repo;
import com.my_project.Repository.Complaint_Repo;
import com.my_project.Repository.Login_Repo;
import com.my_project.Repository.Product_Repo;
import com.my_project.Repository.Reg_Repo;

import com.my_project.Service.Reg_Service;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*")
public class Main_Controller {

	@Autowired 
	Complaint_Repo cr;
	@Autowired
	Reg_Service rs;
	@Autowired
	Reg_Repo rp;
	@Autowired
	Login_Repo lr;
	@Autowired
	Account_Repo ar;
	@Autowired
	Product_Repo pr;
//	@Value("${file.upload-dir}")
//    private String uploadDirectory;

	
	@PostMapping("/Reg")
	public String add(@Valid @RequestBody Registration r,HttpSession ses )
	{
		
		String st=r.getTc();
		String stf="farmer";
		String star="artisan";
		String stc="confectioner";
		String std="designer";
		String stcu="customer";
		String stdid="distributor";
		
		
		

		if(stf.equals(st))
		{
			rs.addf(r,ses);
		}
		
		if(star.equals(st))
		{
			rs.adda(r,ses);
		}

		if(stc.equals(st))
		{
			rs.addc(r,ses);
			
		}

		if(std.equals(st))
		{
			rs.addd(r,ses);
			
		}
		if(stcu.equals(st))
		{
			rs.addcu(r,ses);
			
		}
		if(stdid.equals(st))
		{
			rs.addis(r,ses);
			
		}
		return "Hi " + r.getName() + " your Registration process successfully completed";
		
	}
	

@PostMapping("/Account")
public String add1(@Valid @RequestBody Accounts a,HttpSession ses)
{
	 String currentUser = (String) ses.getAttribute("reguser");
	 if (currentUser != null) {
         System.out.println(currentUser);
         System.out.println("success");
         a.setId(currentUser);
        ar.save(a);
        return "Hi " + a.getId() + " your Registration process successfully completed";
     } 
	 else 
	 {
         System.out.println("Unable to retrieve current user from the session");
         return null;
     }
	 
	
	
}





@PostMapping("/login")
public Login log(@RequestBody Login l, HttpSession session) {
    
   
    return rs.getLog(l,session);
}
@PostMapping(value= {"/addNewProduct/{cid}"})
public Products addNewProduct(@PathVariable("cid") String cid,@RequestBody Products product)
{
	
		
		return rs.addNewProduct(product);

	
}

@GetMapping("/viewproduct")
public List<Products> viewproduct()
{
	return rs.viewProd();
}

@GetMapping("/viewp/{cid}")
public List<Products> viewproduct1(@PathVariable String cid)
{
	 List<Products> products = pr.findByCid(cid);
	return products;
}




@GetMapping("/viewprofile/{cid}")
public ResponseEntity<Registration> viewProfile(@PathVariable String cid, HttpSession session) {
    

        // Check if the session user matches the requested user id
        if (cid != null) {
            // Query the repository to fetch registrations for the current user
            Registration registration = rp.findByCid(cid);
            if (registration != null) {
                return ResponseEntity.ok(registration);
            } else {
                // Return 404 Not Found if the registration is not found
                return ResponseEntity.notFound().build();
            }
        } else {
            // Return 403 Forbidden if the session user does not match the requested user id
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }









@PostMapping("/updateprofile/{cid}")
public Registration updateProfile1(@PathVariable String cid,@RequestBody Registration r, HttpSession session) {
	
	if (cid != null) {
        
        Registration st = rp.findByCid(cid);
        if (st != null) {
	       
	       
	        	if (r.getName().isEmpty()==false) 
	        	{
	        			st.setName(r.getName());
	        			System.out.println(st.getName());
	        	}
	        	if (r.getTc().isEmpty()==false) 
	        	{
	        			st.setTc(r.getTc());
	        			System.out.println(st.getTc());
	        	}
	        	if (r.getAddress().isEmpty() == false) {
	        	    st.setAddress(r.getAddress());
	        	    System.out.println(st.getAddress());
	        	}

	        	if (r.getLandmark().isEmpty() == false) {
	        	    st.setLandmark(r.getLandmark());
	        	    System.out.println(st.getLandmark());
	        	}

	        	if (r.getMailid().isEmpty() == false) {
	        	    st.setMailid(r.getMailid());
	        	    System.out.println(st.getMailid());
	        	}

	        	if (r.getPhone().isEmpty() == false) {
	        	    st.setPhone(r.getPhone());
	        	    System.out.println(st.getPhone());
	        	}

	        	if (r.getAdhar().isEmpty() == false) {
	        	    st.setAdhar(r.getAdhar());
	        	    System.out.println(st.getAdhar());
	        	}

	        	if (r.getUname().isEmpty() == false) {
	        	    st.setUname(r.getUname());
	        	    System.out.println(st.getUname());
	        	}

	        	if (r.getPass().isEmpty() == false) {
	        	    st.setPass(r.getPass());
	        	    System.out.println(st.getPass());
	        	}

	        	if (r.getConp().isEmpty() == false) {
	        	    st.setConp(r.getConp());
	        	    System.out.println(st.getConp());
	        	}

	        	if (r.getOtp().isEmpty() == false) {
	        	    st.setOtp(r.getOtp());
	        	    System.out.println(st.getOtp());
	        	}

	        	  return rp.save(st);
        } else {
            System.out.println("cid not fount");
            return null;
        }
    } else {
    	System.out.println("cid not fount");
        return null;
    }
}
	
@PutMapping("/updateproduct/{cid}/{id}")
public Products updatePro(@PathVariable String cid, @PathVariable Integer id, @RequestBody Products updatedProduct) {
    // Fetch the existing products from the database based on cid
    List<Products> existingProducts = pr.findByCid(cid);

    List<Integer> productIds = new ArrayList<>();
    for (Products product : existingProducts) {
        productIds.add(product.getId());
    }

    // Check if the product exists and if the provided id exists in the list of productIds
    if (!existingProducts.isEmpty() && productIds.contains(id)) {
        // Find the product with the matching id
        for (Products existingProduct : existingProducts) {
            if (Integer.valueOf(existingProduct.getId()).equals(id)) {
                // Update the product with the new values
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setGrade(updatedProduct.getGrade());
                existingProduct.setQuantity(updatedProduct.getQuantity());
                existingProduct.setDes(updatedProduct.getDes());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setP_point(updatedProduct.getP_point());

                // Save the updated product back to the database
                return pr.save(existingProduct);
            }
        }
    }

    // If the product with the provided cid or id does not exist, or if no product is updated
    throw new RuntimeException("Product not found or not updated.");
}
@DeleteMapping("/deleteproduct/{cid}/{id}")
public ResponseEntity<String> deleteProduct(@PathVariable String cid, @PathVariable Integer id) {
    // Fetch the existing products from the database based on cid
    List<Products> existingProducts = pr.findByCid(cid);

    // Check if the product list is not empty
    if (!existingProducts.isEmpty()) {
        // Find the product with the matching id
        for (Products existingProduct : existingProducts) {
        	 if (Integer.valueOf(existingProduct.getId()).equals(id)) {
                // Delete the product from the database
                pr.delete(existingProduct);
                return ResponseEntity.ok("Product with ID " + id + " deleted successfully.");
            }
        }
    }

    // If the product with the provided cid or id does not exist
    throw new RuntimeException("Product not found or not deleted.");
}


@DeleteMapping("/deleteuser/{cid}")
public ResponseEntity<String> delData(@PathVariable String cid,HttpSession session) {
   

	if (cid != null) {
     Registration st = rp.findByCid(cid);
        if (st != null) 
        {
        		rp.delete(st);
        		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } 
        else 
        {
                // If registration not found, return appropriate response
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        } 
		else 
		{
            // Handle scenario when currentUser is null
            return new ResponseEntity<>("ser not logged in", HttpStatus.UNAUTHORIZED);
        }
    } 

@PostMapping("/complaints/{cid}")
public Complaints addcomplaint(@RequestBody Complaints c,@PathVariable String cid)
{
c.setCid(cid);

	 
	return cr.save(c);
	
}
@PostMapping("/querie")
public Querie addQuerie(@RequestBody Querie q)
{
	
	return rs.addQuerie(q);
}


}
























