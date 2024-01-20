package com.marshalling.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.marshalling.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marshalling.dto.Customer;

@RestController
public class JAXB_Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(JAXB_Controller.class);

	@RequestMapping(value = "/writeToFile", method = RequestMethod.POST)
	public String writeFileXML(@RequestBody Customer customer) {
		try {
			File file = new File("D:\\vendorfile\\" + customer.getCustomerName().toUpperCase() + "_"
					+ customer.getCustomerId() + ".xml");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.flush();
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(customer, fileOutputStream);
			return "XML Created successfull";
		} catch (IOException ioException) {
			ioException.printStackTrace();
			return ioException.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
	}

	@RequestMapping(value = "/readXML", method = RequestMethod.POST)
	public String convertXmlToObject(@RequestPart(name = "file") MultipartFile files) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			File obj = new File("D:\\vendorfile\\" + files.getOriginalFilename());
			Customer customer = (Customer) unmarshaller.unmarshal(obj);
			List<Product> list=customer.getProducts();
			return "File Read";
		}  catch (Exception exception) {
			LOGGER.debug(exception.getLocalizedMessage());
			return exception.getLocalizedMessage();
		}
	}
}
