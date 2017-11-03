package kr.ac.jbnu.se.advweb.product.model;

import java.util.Date;
/**
 * 주문 객체
 * @author HongJG
 *
 */
public class Order {
	private String orderNumber;
	private Date date;
	private String custromerId;
	private String productNumber;
	private int count;
	
	
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
	public String getCustromerId() {
		return custromerId;
	}
	public void setCustromerId(String custromerId) {
		this.custromerId = custromerId;
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
