package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/health")
	public void health() {}

	@RequestMapping(
		value = {"redirect"},
		method = RequestMethod.PUT)
    @ResponseBody
    public RedirectView redirectConversionFilesPutRequest() {
        return new RedirectView("https://www.google.com");
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
