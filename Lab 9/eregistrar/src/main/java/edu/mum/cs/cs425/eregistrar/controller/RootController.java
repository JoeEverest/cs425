package edu.mum.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Redirects the site root to the eRegistrar home page.
 */
@Controller
public class RootController {

	@GetMapping("/")
	public String root() {
		return "redirect:/eregistrar/home";
	}
}
