package com.my_project.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Preorder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Cid;
	@NotBlank(message = "ItemName Required")
	private String itemname;
	@NotBlank(message = "Quantity Required")
	private String quantity;
	@NotBlank(message = "Quality Required")
	private String quality;
	@NotNull(message = "Event date is required")
    @Future(message = "Event date must be in the future")
    private LocalDate date; // Use LocalDate for the date field

    @NotNull(message = "Event time is required")
   // @Future(message = "Event time must be in the future")
    private LocalTime time; // Use LocalTime for the time field
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
