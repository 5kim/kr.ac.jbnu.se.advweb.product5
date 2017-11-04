package kr.ac.jbnu.se.advweb.product.model;

import java.sql.Date;
/**
 * 주문 객체
 * @author HongJG
 *
 */
public class Order {
	private String orderNumber;
	private Date date;
	private String customerId;
	private String productNumber;
	private int count;
	
	public Order() {
		
	}
	
	public Order(String orderNumber, Date date, String customerId, String productNumber, int count) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.customerId = customerId;
		this.productNumber = productNumber;
		this.count = count;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustromerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
