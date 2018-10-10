package edu.alex.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import edu.alex.CustomerController;

@RunWith(SpringRunner.class)
@Import({ edu.alex.config.TestConfiguration.class })
@WebMvcTest(CustomerController.class)
public class CustControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test() throws Exception {

		// @formatter:off

		final MvcResult result = mvc.perform(get("/customer/list")
									.contentType(MediaType.TEXT_PLAIN))
									.andExpect(status().isOk())
									.andReturn();

		// @formatter:on

		ModelAndViewAssert.assertModelAttributeAvailable(result.getModelAndView(), "customers");
	}

}
