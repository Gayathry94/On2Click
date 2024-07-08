package com.my_project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String did;
	@NotBlank(message="please enter vehicle number")
	@Column(name="vehicle_number")
	private String no;
	@NotBlank(message="please enter type of vehicle")
	@Column(name="vehicle_type")
	private String type;
	@NotBlank(message="please enter driver number")
	@Column(name="Driver_name")
	private String drivername;
	@NotBlank(message="please enter type of ownership")
	@Column(name="Type_of_ownership")
	private String ownership;
	  @NotBlank(message = "Phone number is required")
	  @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 characters")
	  @Pattern(regexp = "\\d{10,12}", message = "Phone number must contain only digits")
	  @Column(name="Phone_number")
	private String phoneno;
	private String date;
	private String time;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", did=" + did + ", no=" + no + ", type=" + type + ", drivername=" + drivername
				+ ", ownership=" + ownership + ", phoneno=" + phoneno + "]";
	}
	

}
