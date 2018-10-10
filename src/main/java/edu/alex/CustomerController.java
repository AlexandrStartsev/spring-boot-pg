package edu.alex;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	/*@Autowired
	ICustomerDAO dao;*/
	
	@Autowired
	ICustomerRepository mongo;
	
	@GetMapping("/addcustomer")
	public String addCustomerGet(final Model model) {
		model.addAttribute("customer", new CustomerEntityDocument());
		return "addcustomer";
	}
	
	@GetMapping("/list")
	public String showAllCustomers(final Model model) {
		model.addAttribute("customers", mongo.findAll());
		return "listcustomers";
	}
	
	@PostMapping("/addcustomer")
	public String addCustomerPost(final Model model, @Valid @ModelAttribute("customer") CustomerEntityDocument payload, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("customer", payload);
			model.addAttribute("errorMessage", bindingResult.getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining("\n")));
			return "addcustomer";
		}
		mongo.save(payload);
		return "redirect:/index.jsp";
	}
}
