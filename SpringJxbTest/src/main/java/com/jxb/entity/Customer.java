package com.jxb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder = {"name","age","occupation","salary","addressList"})
public class Customer {
    protected String name;
    protected int age;
    protected String occupation;
    protected int salary;
    protected Customer.AddressList addressList;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public Customer.AddressList getAddressList() {
		return addressList;
	}

	public void setAddressList(Customer.AddressList addressList) {
		this.addressList = addressList;
	}


	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "",propOrder = {"address"})
	public static class AddressList{
		protected List<Address>address=new ArrayList<>();

		public List<Address> getAddress() {
			return address;
		}

		public void setAddress(List<Address> address) {
			this.address = address;
		}
		
	}

}
