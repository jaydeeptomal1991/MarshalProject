package com.marshalling.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"productId",
		"productName",
		"productPrice"
})
public class Product {
	@XmlElement(name = "productId")
	private int productId;
	@XmlElement(name = "productName")
	private String productName;
	@XmlElement(name = "productPrice")
	private int productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productPrice=" + productPrice +
				'}';
	}
}
