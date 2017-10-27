package kr.ac.jbnu.se.advweb.product.model;


/**
 * 쿠폰 정보
 */
import java.util.Date;

public class Coopon {
	private String serialNumber;
	private String userId;
	private int discountRate;
	private Date period;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	
}
