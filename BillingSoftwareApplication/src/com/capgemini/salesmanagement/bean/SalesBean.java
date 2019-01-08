package com.capgemini.salesmanagement.bean;

import java.util.Date;

public class SalesBean {
	
	private String salesId;
	private String productCode;
	private String quantity;
	private Date salesDate;
	private String lineTotal;
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(String lineTotal) {
		this.lineTotal = lineTotal;
	}
	
	@Override
	public String toString() {
		return "SalesBean [salesId=" + salesId + ", productCode=" + productCode + ", quantity=" + quantity
				+ ", salesDate=" + salesDate + ", lineTotal=" + lineTotal + "]";
	}
}
