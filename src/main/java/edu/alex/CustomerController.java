package edu.alex;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@PersistenceContext(unitName="somedb")
    private EntityManager em;
	
	@GetMapping("/addcustomer")
	public String addCustomerGet(final Model model, HttpServletResponse response) {
		model.addAttribute("customer", new CustomerEntity());
		return "addcustomer";
	}
	
	@Transactional
	@PostMapping("/addcustomer")
	public String addCustomerPost(final Model model, @Valid @ModelAttribute("customer") CustomerEntity payload, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("customer", payload);
			model.addAttribute("errorMessage", bindingResult.getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(Collectors.joining("\n")));
			return "addcustomer";
		}
		em.persist(payload);
		return "redirect:/index.jsp";
	}
}
