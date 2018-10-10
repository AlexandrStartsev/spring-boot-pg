package edu.alex.cookietest;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-rest")
public class CookieRestController {

	@GetMapping(path = "/uuid", produces = "text/plain")
	public String getUUIDFromRequest(final @CookieValue(CookieController.UUID_TEST_COOKIE) String uuid) {
		return uuid;
	}

}
