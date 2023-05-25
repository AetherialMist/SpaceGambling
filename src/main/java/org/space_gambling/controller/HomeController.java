package org.space_gambling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
        log.info("hit index");
		return "index";
	}

}