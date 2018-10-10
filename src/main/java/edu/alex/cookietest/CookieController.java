package edu.alex.cookietest;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class CookieController {
	
	public final static String UUID_TEST_COOKIE =  "uuid_test";

	@Autowired
	public IUUIDGenerator uuid;
	
	@GetMapping("/seed")
	public String method(final HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookie = new Cookie(UUID_TEST_COOKIE, uuid.getUUID());
		cookie.setPath("/");
		response.addCookie(cookie);
		response.getWriter().write("<html><body><h3>" + uuid.getUUID() + "</h3>&nbsp;<a href='/test-rest/uuid'>rest</a></body></html>");
		return null;
	}
}
