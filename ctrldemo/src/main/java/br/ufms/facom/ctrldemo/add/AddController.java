package br.ufms.facom.ctrldemo.add;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/add")
public class AddController {

	@GetMapping
	public ResponseEntity<String> add_get(
		@RequestParam(name="a") String a,
		@RequestParam(name="b") String b,
		@CookieValue(name="op-count", defaultValue="0") String count
	) {
		String sumText;
		try {
			sumText = String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
		} catch (Exception e) {
			sumText = "Error: " + e.getMessage();
		}

		count = String.valueOf(Integer.parseInt(count) + 1);
		ResponseCookie cookie = ResponseCookie.from("op-count", count).build();
		return ResponseEntity.ok()
			.header(HttpHeaders.SET_COOKIE, cookie.toString())
			.header(HttpHeaders.CONTENT_TYPE, "text/plain")
			.body("Cookie: " + cookie.toString() + "\r\nSum: " + sumText);
	}

	@PostMapping
	public ResponseEntity<String> add_post(
		@RequestBody MultiValueMap<String, String> params,
		@CookieValue(name="op-count", defaultValue="0") String count
	) {
		String sumText;
		try {
			double a = Double.parseDouble(params.getFirst("a"));
			double b = Double.parseDouble(params.getFirst("b"));
			sumText = String.valueOf(a + b);
		} catch (Exception e) {
			sumText = "Error: " + e.getMessage();
		}

		count = String.valueOf(Integer.parseInt(count) + 1);
		ResponseCookie cookie = ResponseCookie.from("op-count", count).build();
		return ResponseEntity.ok()
			.header(HttpHeaders.SET_COOKIE, cookie.toString())
			.header(HttpHeaders.CONTENT_TYPE, "text/plain")
			.body("Cookie: " + cookie.toString() + "\r\nSum: " + sumText);
	}
}
