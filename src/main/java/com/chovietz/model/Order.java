package com.chovietz.model;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Order")
public class Order {
	@Id
	private String id;
	private User customer;


	private String delivery_address;
	private String status;
	private String shopID;
	private User shop;
	private Object shipper;
	private String payment_type;
	private Boolean is_paid;
	private Object[] product;
	private int month;
	private int quater;
	private int year;
	private Date created_date;
		public Order(String id,User customer, String delivery_address, String status, User shop, Object shipper,
			String payment_type, Boolean is_paid, Object[] product) {
			this.id = id;
				this.customer = customer;
		this.delivery_address = delivery_address;
		this.status = status;
		this.shop = shop;
		this.shipper = shipper;
		this.payment_type = payment_type;
		this.is_paid = is_paid;
		this.product = product;
	}
	public Date getCreated_date() {
			return created_date;
		}
		public void setCreated_date(Date created_date) {
			this.created_date = created_date;
		}
	public String getShopID() {
			return shopID;
		}
		public void setShopID(String shopID) {
			this.shopID = shopID;
		}
	public String getId() {
		return id;
	}
	public Order() {
		super();
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getShop() {
		return shop;
	}

	public void setShop(User shop) {
		this.shop = shop;
	}

	public Object getShipper() {
		return shipper;
	}

	public void setShipper(Object shipper) {
		this.shipper = shipper;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public Boolean getIs_paid() {
		return is_paid;
	}

	public void setIs_paid(Boolean is_paid) {
		this.is_paid = is_paid;
	}

	public Object[] getProduct() {
		return product;
	}

	public void setProduct(Object[] product) {
		this.product = product;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getQuater() {
		return quater;
	}

	public void setQuater(int quater) {
		this.quater = quater;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
