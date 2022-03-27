package coding.mentor.entity;

import java.util.Date;

public class Order {
	public int id;
	public String address;
	public String submitDate;
	public String status;
	public String shipDate;
	public String userEmail;
	public Float price;
	
	
	
	public Order() {
		super();
	}
	public Order(int id, String address, String submitDate, String userEmail, Float price) {
		super();
		this.id = id;
		this.address = address;
		this.submitDate = submitDate;
		this.userEmail = userEmail;
		this.price = price;
	}
	public Order(int id, String address, String submitDate, String status, String shipDate, String userEmail,
			Float price) {
		super();
		this.id = id;
		this.address = address;
		this.submitDate = submitDate;
		this.status = status;
		this.shipDate = shipDate;
		this.userEmail = userEmail;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
