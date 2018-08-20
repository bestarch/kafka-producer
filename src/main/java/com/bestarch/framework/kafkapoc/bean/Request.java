package com.bestarch.framework.kafkapoc.bean;

/**
 * 
 * @author bestarch
 *
 */
public class Request {

	private int requestId;
	
	private String requestName;
	
	private String details;
	
	private double cost;
	
	private String serialNumber;
	
	private String miscDetails;
	
	private int count;
	
	public Request() { }

	public Request(int requestId, String requestName, String details, double cost, String serialNumber,
			String miscDetails, int count) {
		this.requestId = requestId;
		this.requestName = requestName;
		this.details = details;
		this.cost = cost;
		this.serialNumber = serialNumber;
		this.miscDetails = miscDetails;
		this.count = count;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMiscDetails() {
		return miscDetails;
	}

	public void setMiscDetails(String miscDetails) {
		this.miscDetails = miscDetails;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
