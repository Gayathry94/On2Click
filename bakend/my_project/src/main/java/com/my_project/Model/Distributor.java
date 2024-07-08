package com.my_project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Distributor {
	
	@Id
	private String id;
	
	
	@NotBlank(message="Name Required")
	@Column(name="Name")
	private String name;
	@Email(message = "Invalid email address")
    @Column(unique = true) 
	private String mailid;
	  @NotBlank(message = "Phone number is required")
	    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 characters")
	    @Pattern(regexp = "\\d{10,12}", message = "Phone number must contain only digits")
	@Column(name="Phone_NO")
	private String phone;
	@NotBlank(message="Address Required")
	@Column(name="Address")
	private String address;
	
	@NotBlank(message="Owner Name  Required")
	@Column(name="Owner_Name")
	private String oname;
	
	@NotBlank(message="Type Of Ownership Required")
	@Column(name="Type_Of_OwnerShip")
	private String tyow;
	
	@NotBlank(message="Total no of Vehicles Required")
	@Column(name="NO_Vehicles")
	private String novehicles;
	
	private String date;
	
	private String time;
	
	@NotBlank(message="UserName Required")
	@Column(name="User_Name")
	private String uname;
	
	@NotBlank(message="Password Required")
	@Column(name="Password")
	private String pass;
	@NotBlank(message = "Confirm Password Required")
	@Column(name="Confirm_Password")
	private String conp;
	
	
	
	
	
	public String getConp() {
		return conp;
	}
	public void setConp(String conp) {
		this.conp = conp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getTyow() {
		return tyow;
	}
	public void setTyow(String tyow) {
		this.tyow = tyow;
	}
	public String getNovehicles() {
		return novehicles;
	}
	public void setNovehicles(String novehicles) {
		this.novehicles = novehicles;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	 @AssertTrue(message = "Password and confirm password must match")
	    private boolean isPasswordConfirmed() {
	        return pass != null && pass.equals(conp);
	 }

}
