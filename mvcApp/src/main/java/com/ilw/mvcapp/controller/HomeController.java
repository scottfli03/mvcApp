package com.ilw.mvcapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ilw.mvcapp.config.AppConfig;
import com.ilw.mvcapp.model.Customer;
import com.ilw.mvcapp.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
    
	private CustomerService customerService = context.getBean(CustomerService.class);
	

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer c) {
		System.out.println(c);
		if (c.getCustomerID() == 0) {
			// new customer, add it
			this.customerService.addCustomer(c);
		}
		// else{
		// //existing customer, call update
		// this.customerService.updateCustomer(p);
		// }

		return "home";

	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String doesThisMatter(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// @RequestMapping(value = "/create")
	// @ResponseBody
	// public String create(@RequestParam String fName,
	// @RequestParam String lName,
	// @RequestParam String email,
	// @RequestParam String phone,
	// @RequestParam String addr1,
	// @RequestParam String addr2,
	// @RequestParam String city,
	// @RequestParam String state,
	// @RequestParam String zip) {
	// String customerID = "";
	// try {
	// Customer customer = new Customer();
	// customer.setfName(fName);
	// customer.setlName(lName);
	// customer.setEmail(email);
	// customer.setPhone(phone);
	// customer.setAddr1(addr1);
	// customer.setAddr2(addr2);
	// customer.setCity(city);
	// customer.setState(state);
	// customer.setZip(zip);
	// customerRepository.save(customer);
	// customerID = String.valueOf(customer.getCustomerID());
	// } catch(Exception ex) {
	// return "Error creating the user: " + ex.toString();
	// }
	// return "User succesfully created with id = " + customerID;
	// }
}
