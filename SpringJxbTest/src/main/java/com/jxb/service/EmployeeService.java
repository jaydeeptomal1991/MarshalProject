package com.jxb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;
import com.jxb.entity.Address;
import com.jxb.entity.Customer;
import com.jxb.entity.Employee;

@Service
public class EmployeeService {

	public void marshalling(StringBuilder xml, List<Address> address) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employee e = (Employee) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml.toString())));
		Customer obj = new Customer();
		obj.setName(e.getName());
		obj.setAge(e.getAge());
		obj.setOccupation(e.getOccupation());
		obj.setSalary(e.getSalary());
		Customer.AddressList a = new Customer.AddressList();
		for (Address ad : address) {
			a.getAddress().add(ad);
		}
		obj.setAddressList(a);
		File file=new File("D:\\vendor\\response.xml");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.flush();
		JAXBContext jax = JAXBContext.newInstance(Customer.class);
		Marshaller marshaller = jax.createMarshaller();
		marshaller.marshal(obj, fileOutputStream);
		System.out.println("XML Response Created");

	}
}
