package com.chovietz.model;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Order")
public class Order {
	@Id
	private String id=null;
	private String customerID=null;
	private User customer=null;
	private String delivery_address=null;
	private String status=null;
	private String typeOrder=null;
	private String shopID=null;
	private User shop=null;
	private User shipper=null;
	private String shipperID=null;
	private String payment_type=null;
	private Boolean is_paid=null;
	private Object[] product=null;
	private int month;
	private int quater;
	private int year;
	private Date created_date=null;
	private Date updated_date=null;
	public Order(String id,User customer, String delivery_address, String status, User shop, User shipper,
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
		this.customerID = customer != null ? customer.getId() + "" : null;
		this.shopID = shop != null ? shop.getId() + "" : null;
		this.shipperID = shipper != null ? shipper.getId() + "" : null;
	}
	public String getTypeOrder() {
		return typeOrder;
	}
	public void setTypeOrder(String typeOrder) {
		this.typeOrder = typeOrder;
	}
	public Date getUpdated_date() {
			return updated_date;
		}
		public void setUpdated_date(Date updated_date) {
			this.updated_date = updated_date;
		}
	public String getShipperID() {
			return shipperID;
		}
		public void setShipperID(String shipperID) {
			this.shipperID = shipperID;
		}
	public String getCustomerID() {
			return customerID;
		}
		public void setCustomerID(String customerID) {
			this.customerID = customerID;
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

	public User getShipper() {
		return shipper;
	}

	public void setShipper(User shipper) {
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
