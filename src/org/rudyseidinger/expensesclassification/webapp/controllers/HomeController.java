package org.rudyseidinger.expensesclassification.webapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}